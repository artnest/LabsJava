package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageDisconnect extends Message {
    private static final long serialVersionUID = 1L;

    public Message.Data data = new Message.Data();

    MessageDisconnect() {
        super.setup(Protocol.CMD_DISCONNECT);
    }

    @Override
    public Message.Data getData() {
        return data;
    }
}
