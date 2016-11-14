package homework.lab10;

class MessageDisconnect extends Message {
    private static final long serialVersionUID = 1L;

    MessageDisconnect() {
        super(Protocol.CMD_DISCONNECT);
    }
}
