package homework.lab10;

class MessageUser extends Message {
    private static final long serialVersionUID = 1L;

    MessageUser() {
        super(Protocol.CMD_USER);
    }
}
