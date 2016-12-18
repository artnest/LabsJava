package homework.lab13;

public class MessageContext extends Message {
    private static final long serialVersionUID = 1L;

    public Byte classID;
    public Message.Data data = new Message.Data();

    public MessageContext() {
        super.setup(Protocol.CMD_CONTEXT);
        classID = 0;
    }

    MessageContext(Message msg) {
        super.setup(Protocol.CMD_CONTEXT);
        classID = msg.getID();
    }

    @Override
    protected Message.Data getData() {
        return data;
    }

    public Class<? extends Message> getXmlClass() {
        return MessageXml.classByID(classID);
    }
}
