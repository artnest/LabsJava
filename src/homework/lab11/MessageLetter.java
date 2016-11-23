package homework.lab11;

class MessageLetter extends Message {
    private static final long serialVersionUID = 1L;

    private String text;

    String getText() {
        return text;
    }

    MessageLetter(String text) {
        super(Protocol.CMD_LETTER);
        this.text = text;
    }
}
