package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageConnectUser", namespace = "MessageConnectUser")
@XmlRootElement(name = "MessageConnectUser")
class MessageConnectUser extends MessageNotify {
    private static final long serialVersionUID = 1L;

//    public Message.Data data = new Message.Data();

    MessageConnectUser(String userNick) {
//        super.setup(Protocol.CMD_CONNECT_USER);
        super(userNick, Protocol.CMD_CONNECT_USER);
    }

//    @Override
//    public Message.Data getData() {
//        return data;
//    }
}
