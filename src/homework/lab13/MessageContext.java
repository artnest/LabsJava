package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageContext", propOrder = {
        "classID",
        "data"
})
@XmlRootElement(name = "MessageContext")
public class MessageContext extends Message {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    public Byte classID;
    @XmlElement(required = true)
    public Message.Data data = new Message.Data();

    public MessageContext() {
        super.setup(Protocol.CMD_CONTEXT);
        classID = 0;
    }

    MessageContext(Message msg) {
        super.setup(Protocol.CMD_CONTEXT);
        classID = msg.getID();
    }

    @Override
    protected Message.Data getData() {
        return data;
    }

    public Class<? extends Message> getXmlClass() {
        return MessageXml.classByID(classID);
    }
}
