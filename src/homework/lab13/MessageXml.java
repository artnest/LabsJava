package homework.lab13;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

abstract class MessageXml implements Serializable {
    private static final long serialVersionUID = 1L;

    static void toXml(MessageXml msg, OutputStream os) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(msg.getClass());
        Marshaller m = context.createMarshaller();
        m.marshal(msg, os);
    }

    static MessageXml fromXml(Class<? extends MessageXml> what, InputStream is) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(what);
        Unmarshaller u = context.createUnmarshaller();
        return (MessageXml) u.unmarshal(is);
    }

    static void writeMsg(DataOutputStream os, MessageXml msg) throws JAXBException, IOException {
        writeViaByteArray(os, msg);
    }

    private static void writeViaByteArray(DataOutputStream os, MessageXml msg) throws JAXBException, IOException {
        try (ByteArrayOutputStream bufOut = new ByteArrayOutputStream(512)) {
            try (DataOutputStream out = new DataOutputStream(bufOut)) {
                String name = msg.getClass().getName();
                out.writeUTF(name);
                toXml(msg, out);
                out.flush();
            }

            byte[] res = bufOut.toByteArray();
            os.writeInt(res.length);
            os.write(res);
            os.flush();
        }
    }

    static void readMsg(DataInputStream is) throws JAXBException, IOException, ClassNotFoundException {
        readViaByteArray(is);
    }

    @SuppressWarnings("unchecked")
    private static MessageXml readViaByteArray(DataInputStream is) throws IOException, ClassNotFoundException, JAXBException {
        int length = is.readInt();
        byte[] raw = new byte[length];
        int idx = 0;

        while (idx < length) {
            int n = is.read(raw, idx, length - idx);
            idx += n;
        }

        try (ByteArrayInputStream bufIn = new ByteArrayInputStream(raw)) {
            try (DataInputStream in = new DataInputStream(bufIn)) {
                String name = in.readUTF();
                return fromXml((Class<? extends MessageXml>) Class.forName(name), in);
            }
        }
    }

    static String lastQueryError = null;

    static boolean query2(Message msg, DataInputStream is, DataOutputStream os) throws JAXBException, IOException {
        MessageContext context = new MessageContext(msg);
        toXml(context, os);
        os.flush();

        MessageResult result = (MessageResult) fromXml(MessageContextResult.class, is);

        if (!result.error()) {
            lastQueryError = null;
            MessageXml.toXml(msg, os);
            os.flush();
            return true;
        }

        lastQueryError = result.getErrorMessage();
        return false;
    }

    static Class<? extends MessageResult> classResultByID(byte id) {
        assert Protocol.validID(id);
        switch (id) {
            case Protocol.CMD_CONTEXT:
                return MessageContextResult.class;
            case Protocol.CMD_CONNECT:
                return MessageConnectResult.class;
            case Protocol.CMD_DISCONNECT:
                return null;
            case Protocol.CMD_USER:
                return MessageUserResult.class;
            case Protocol.CMD_CHECK_MAIL:
                return MessageCheckMailResult.class;
            case Protocol.CMD_LETTER:
                return MessageLetterResult.class;
            /*case Protocol.CMD_CONNECT_USER:
                return MessageConnectUser.class;
            case Protocol.CMD_DISCONNECT_USER:
                return MessageDisconnectUser.class;*/
            default:
                    return null;
        }
    }

    static Class<? extends Message> classByID(byte id) {
        assert Protocol.validID(id);
        switch (id) {
            case Protocol.CMD_CONTEXT:
                return MessageContext.class;
            case Protocol.CMD_CONNECT:
                return MessageConnect.class;
            case Protocol.CMD_DISCONNECT:
                return null;
            case Protocol.CMD_USER:
                return MessageUser.class;
            case Protocol.CMD_CHECK_MAIL:
                return MessageCheckMail.class;
            case Protocol.CMD_LETTER:
                return MessageLetter.class;
            /*case Protocol.CMD_CONNECT_USER:
                return MessageConnectUser.class;
            case Protocol.CMD_DISCONNECT_USER:
                return MessageDisconnectUser.class;*/
            default:
                return null;
        }
    }

    static MessageResult query(Message msg,
                               DataInputStream is,
                               DataOutputStream os,
                               Class<? extends MessageResult> what) throws JAXBException, IOException {
        if (query2(msg, is, os)) {
            return (MessageResult) fromXml(what, is);
        }

        return null;
    }

    static Message getMessage(DataInputStream is, DataOutputStream os) throws JAXBException, IOException {
        MessageContext context = (MessageContext) fromXml(MessageContext.class, is);
        Class<? extends Message> what = context.getXmlClass();

        if (what != null) {
            toXml(new MessageContextResult(), os);
        } else {
            toXml(new MessageContextResult("Invalid XML class ID"), os);
        }
        os.flush();

        if (what != null) {
            return (Message) fromXml(what, is);
        }

        return null;
    }

    static void answer(MessageResult msg, DataOutputStream os) throws JAXBException, IOException {
        toXml(msg, os);
        os.flush();
    }
}
