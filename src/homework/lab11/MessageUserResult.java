package homework.lab11;

import java.io.Serializable;

class MessageUserResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    String[] userNicks = null;

    MessageUserResult(String errorMessage) { // error
        super(Protocol.CMD_USER, errorMessage);
    }

    MessageUserResult(String[] userNicks) { // No errors
        super(Protocol.CMD_USER);
        this.userNicks = userNicks;
    }
}
