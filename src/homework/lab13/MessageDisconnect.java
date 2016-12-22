package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageDisconnect", propOrder = {
        "data"
}, namespace = "MessageDisconnect")
@XmlRootElement(name = "MessageDisconnect")
class MessageDisconnect extends Message {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    public Message.Data data = new Message.Data();

    MessageDisconnect() {
        super.setup(Protocol.CMD_DISCONNECT);
    }

    @Override
    public Message.Data getData() {
        return data;
    }
}
