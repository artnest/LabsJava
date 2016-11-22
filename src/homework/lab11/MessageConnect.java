package homework.lab11;

import java.io.Serializable;

class MessageConnect extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    String userNick;
    String userFullName;

    MessageConnect(String userNick, String userFullName) {
        super(Protocol.CMD_CONNECT);
        this.userNick = userNick;
        this.userFullName = userFullName;
    }
}
