package homework.lab10;

class MessageCheckMail extends Message {
    private static final long serialVersionUID = 1L;

    MessageCheckMail() {
        super(Protocol.CMD_CHECK_MAIL);
    }
}
