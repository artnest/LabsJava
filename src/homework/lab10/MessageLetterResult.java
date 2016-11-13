package homework.lab10;

import java.io.Serializable;

class MessageLetterResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    MessageLetterResult(String errorMessage) { //error
        super(Protocol.CMD_LETTER, errorMessage);
    }

    MessageLetterResult() { // No errors
        super(Protocol.CMD_LETTER);
    }
}
