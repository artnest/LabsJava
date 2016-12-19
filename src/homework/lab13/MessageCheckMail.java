package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageCheckMail extends Message {
    private static final long serialVersionUID = 1L;

    public Message.Data data = new Message.Data();

    @Override
    protected Message.Data getData() {
        return data;
    }

    MessageCheckMail() {
        super.setup(Protocol.CMD_CHECK_MAIL);
    }
}
