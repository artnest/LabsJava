package homework.lab10;

import java.io.Serializable;

public class MessageDisconnectResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public MessageDisconnectResult(String errorMessage) { // error
        super(Protocol.CMD_DISCONNECT, errorMessage);
    }

    public MessageDisconnectResult() { // No error
        super(Protocol.CMD_DISCONNECT);
    }
}