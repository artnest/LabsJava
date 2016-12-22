package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageDisconnectUser", namespace = "MessageDisconnectUser")
@XmlRootElement(name = "MessageDisconnectUser")
class MessageDisconnectUser extends MessageNotify {
    private static final long serialVersionUID = 1L;

//    public Message.Data data = new Message.Data();

    MessageDisconnectUser(String userNick) {
        super(userNick, Protocol.CMD_DISCONNECT_USER);
    }
//
//    @Override
//    public Message.Data getData() {
//        return data;
//    }
}
