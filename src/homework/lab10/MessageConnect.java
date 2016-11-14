package homework.lab10;

class MessageConnect extends Message {
    private static final long serialVersionUID = 1L;

    String userNick;
    String userFullName;

    MessageConnect(String userNick, String userFullName) {
        super(Protocol.CMD_CONNECT);
        this.userNick = userNick;
        this.userFullName = userFullName;
    }
}
