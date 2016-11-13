package homework.lab10;

import java.io.Serializable;

class MessageDisconnectResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    MessageDisconnectResult(String errorMessage) { // error
        super(Protocol.CMD_DISCONNECT, errorMessage);
    }

    MessageDisconnectResult() { // No error
        super(Protocol.CMD_DISCONNECT);
    }
}
