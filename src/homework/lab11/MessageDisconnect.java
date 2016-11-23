package homework.lab11;

class MessageDisconnect extends Message {
    private static final long serialVersionUID = 1L;

    MessageDisconnect() {
        super(Protocol.CMD_DISCONNECT);
    }
}
