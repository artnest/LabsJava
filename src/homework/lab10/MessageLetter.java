package homework.lab10;

import java.io.Serializable;

public class MessageLetter extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public String text;

    public MessageLetter(String text) {
        super(Protocol.CMD_LETTER);
        this.text = text;
    }
}
