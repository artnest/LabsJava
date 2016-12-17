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

    public static void writeMsg(DataOutputStream os, MessageXML msg) {
        writeViaByteArray(os, msg);
    }

    private static void writeViaByteArray(DataOutputStream os, MessageXML msg) {

    }

    public static void readMsg(DataInputStream is) {
        readViaByteArray(os, msg);
    }
}
