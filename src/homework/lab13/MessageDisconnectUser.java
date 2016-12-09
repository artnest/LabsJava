package homework.lab13;

class MessageDisconnectUser extends MessageNotify {
    private static final long serialVersionUID = 1L;

    MessageDisconnectUser(String userNick) {
        super(userNick, Protocol.CMD_DISCONNECT_USER);
    }
}
