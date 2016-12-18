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

    static boolean query2(Message msg, DataInputStream is, DataOutputStream os) {
        MessageContext context = new MessageContext(msg);
        toXml(context, os);
        os.flush();

        MessageResult result = fromXml(MessageContextResult.class, is);
    }
}
