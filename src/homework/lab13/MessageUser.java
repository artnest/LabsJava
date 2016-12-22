package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageUser", propOrder = {
        "data"
}, namespace = "MessageUser")
@XmlRootElement(name = "MessageUser")
class MessageUser extends Message {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    public Message.Data data = new Message.Data();

    @Override
    public Data getData() {
        return data;
    }

    MessageUser() {
        super.setup(Protocol.CMD_USER);
    }
}
