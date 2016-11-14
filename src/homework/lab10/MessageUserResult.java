package homework.lab10;

class MessageUserResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    String[] userNicks = null;

    MessageUserResult(String errorMessage) { // error
        super(Protocol.CMD_USER, errorMessage);
    }

    MessageUserResult(String[] userNicks) { // No errors
        super(Protocol.CMD_USER);
        this.userNicks = userNicks;
    }
}
