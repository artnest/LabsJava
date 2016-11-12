package homework.lab10;

import java.io.Serializable;

public class MessageConnect extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public String userNick;
    public String userFullName;

    public MessageConnect(String userNick, String userFullName) {
        super(Protocol.CMD_CONNECT);
        this.userNick = userNick;
        this.userFullName = userFullName;
    }
}
