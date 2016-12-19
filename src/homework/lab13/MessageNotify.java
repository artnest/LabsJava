package homework.lab13;

abstract class MessageNotify extends Message {
    private static final long serialVersionUID = 1L;

    private String userNick;

    public Message.Data data = new Message.Data();

    String getUserNick() {
        return userNick;
    }

    MessageNotify(String userNick, byte id) {
        super.setup(id);
        this.userNick = userNick;
    }

    @Override
    public Message.Data getData() {
        return data;
    }
}
