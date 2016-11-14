package homework.lab10;

class MessageLetter extends Message {
    private static final long serialVersionUID = 1L;

    String text;

    MessageLetter(String text) {
        super(Protocol.CMD_LETTER);
        this.text = text;
    }
}
