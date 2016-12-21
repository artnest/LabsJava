package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO fix XML generation
@XmlType(name = "MessageNotify")
@XmlRootElement(name = "MessageNotify")
abstract class MessageNotify extends Message {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    private String userNick;

    @XmlElement(required = true)
    public Message.Data data = new Message.Data();

    String getUserNick() {
        return userNick;
    }

    MessageNotify(String userNick, byte id) {
        super.setup(id);
        this.userNick = userNick;
    }

    @Override
    public Message.Data getData() {
        return data;
    }
}
