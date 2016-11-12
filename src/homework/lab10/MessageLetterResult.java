package homework.lab10;

import java.io.Serializable;

public class MessageLetterResult extends MessageResult implements Serializable {
    private static final long serialVersionUID = 1L;

    public MessageLetterResult(String errorMessage) { //error
        super(Protocol.CMD_LETTER, errorMessage);
    }

    public MessageLetterResult() { // No errors
        super(Protocol.CMD_LETTER);
    }
}