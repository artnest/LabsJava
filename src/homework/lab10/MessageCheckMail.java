package homework.lab10;

import java.io.Serializable;

class MessageCheckMail extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    MessageCheckMail() {
        super(Protocol.CMD_CHECK_MAIL);
    }
}
