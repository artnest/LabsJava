package homework.lab13;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public abstract class MessageXML implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void toXML(MessageXML msg, OutputStream os) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(msg.getClass());
        Marshaller m = context.createMarshaller();
        m.marshal(msg, os);
    }

    public static MessageXML fromXML(Class<? extends MessageXML> what, InputStream is) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(what);
        Unmarshaller u = context.createUnmarshaller();
        return (MessageXML) u.unmarshal(is);
    }

    public static void writeMsg(DataOutputStream os, MessageXML msg) throws JAXBException, IOException {
        writeViaByteArray(os, msg);
    }

    private static void writeViaByteArray(DataOutputStream os, MessageXML msg) throws JAXBException, IOException {
        try (ByteArrayOutputStream bufOut = new ByteArrayOutputStream(512)) {
            try (DataOutputStream out = new DataOutputStream(bufOut)) {
                String name = msg.getClass().getName();
                out.writeUTF(name);
                toXML(msg, out);
                out.flush();
            }

            byte[] res = bufOut.toByteArray();
            os.writeInt(res.length);
            os.write(res);
            os.flush();
        }
    }

    public static void readMsg(DataInputStream is) throws JAXBException, IOException, ClassNotFoundException {
        readViaByteArray(is);
    }

    private static MessageXML readViaByteArray(DataInputStream is) throws IOException, ClassNotFoundException, JAXBException {
        int length = is.readInt();
        byte[] raw = new byte[length];
        int idx = 0;
        int num = length;

        while (idx < num) {
            int n = is.read(raw, idx, num - idx);
            idx += n;
        }

        try (ByteArrayInputStream bufIn = new ByteArrayInputStream(raw)) {
            try (DataInputStream in = new DataInputStream(bufIn)) {
                String name = in.readUTF();
                return fromXML((Class<? extends MessageXML>) Class.forName(name), in);
            }
        }
    }
}
