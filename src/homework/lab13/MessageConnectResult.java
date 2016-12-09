package homework.lab13;

class MessageConnectResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    MessageConnectResult(String errorMessage) { // error
        super(Protocol.CMD_CONNECT, errorMessage);
    }

    MessageConnectResult() { // No error
        super(Protocol.CMD_CONNECT);
    }
}
