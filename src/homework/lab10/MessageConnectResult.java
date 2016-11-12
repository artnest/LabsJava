package homework.lab10;

import java.io.Serializable;

public class MessageConnectResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public MessageConnectResult(String errorMessage) { // error
        super(Protocol.CMD_CONNECT, errorMessage);
    }

    public MessageConnectResult() { // No error
        super(Protocol.CMD_CONNECT);
    }
}