package homework.lab11;

import java.io.Serializable;

class MessageDisconnect extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    MessageDisconnect() {
        super(Protocol.CMD_DISCONNECT);
    }
}
