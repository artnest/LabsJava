package homework.lab13;

public class MessageContext extends Message {
    private static final long serialVersionUID = 1L;

    public Byte classID;
    public Data data = new Data();

    MessageContext(Message msg) {
        super.setup(Protocol.CMD_CONTEXT);
    }

    @Override
    protected Data getData() {
        return data;
    }
}
