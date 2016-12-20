package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageConnect", propOrder = {
        "userNick",
        "userFullName",
        "data"
})
@XmlRootElement(name = "MessageConnect")
class MessageConnect extends Message {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    private String userNick;
    @XmlElement(required = true)
    private String userFullName;
    @XmlElement(required = true)
    public Message.Data data = new Message.Data();

    String getUserNick() {
        return userNick;
    }

    String getUserFullName() {
        return userFullName;
    }

    MessageConnect(String userNick, String userFullName) {
        super.setup(Protocol.CMD_CONNECT);
        this.userNick = userNick;
        this.userFullName = userFullName;
    }

    public MessageConnect() {
        super.setup(Protocol.CMD_CONNECT);
    }

    @Override
    protected Message.Data getData() {
        return data;
    }
}
