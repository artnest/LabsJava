package homework.lab10;

class MessageCheckMailResult extends MessageResult {
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
