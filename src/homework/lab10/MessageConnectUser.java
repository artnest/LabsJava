package homework.lab10;

class MessageConnectUser extends MessageNotify {
    private static final long serialVersionUID = 1L;

    MessageConnectUser(String userNick) {
        super(userNick, Protocol.CMD_CONNECT_USER);
    }
}
