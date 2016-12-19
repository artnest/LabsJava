package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageUser extends Message {
    private static final long serialVersionUID = 1L;

    public Message.Data data = new Message.Data();

    @Override
    public Data getData() {
        return data;
    }

    MessageUser() {
        super.setup(Protocol.CMD_USER);
    }
}
