package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageConnect extends Message {
    private static final long serialVersionUID = 1L;

    private String userNick;
    private String userFullName;
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
