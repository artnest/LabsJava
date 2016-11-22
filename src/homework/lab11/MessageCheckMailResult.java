package homework.lab11;

import java.io.Serializable;

class MessageCheckMailResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    String[] letters = null;

    MessageCheckMailResult(String errorMessage) { // error
        super(Protocol.CMD_CHECK_MAIL, errorMessage);
    }

    MessageCheckMailResult(String[] letters) { // No errors
        super(Protocol.CMD_CHECK_MAIL);
        this.letters = letters;
    }
}
