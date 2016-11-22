package homework.lab11;

import java.io.Serializable;

class MessageUser extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    MessageUser() {
        super(Protocol.CMD_USER);
    }
}
