package homework.lab11;

import java.io.Serializable;

class MessageConnectResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    MessageConnectResult(String errorMessage) { // error
        super(Protocol.CMD_CONNECT, errorMessage);
    }

    MessageConnectResult() { // No error
        super(Protocol.CMD_CONNECT);
    }
}
