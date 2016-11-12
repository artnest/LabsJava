package homework.lab10;

import java.io.Serializable;

public class MessageUserResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public String[] userNicks = null;

    public MessageUserResult(String errorMessage) { // error
        super(Protocol.CMD_USER, errorMessage);
    }

    public MessageUserResult(String[] userNicks) { // No errors
        super(Protocol.CMD_USER);
        this.userNicks = userNicks;
    }
}