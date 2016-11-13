package homework.lab10;

import java.io.Serializable;

class MessageLetter extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    String text;

    MessageLetter(String text) {
        super(Protocol.CMD_LETTER);
        this.text = text;
    }
}
