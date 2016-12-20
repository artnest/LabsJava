package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageCheckMail", propOrder = {
        "data"
})
@XmlRootElement(name = "MessageCheckMail")
class MessageCheckMail extends Message {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    public Message.Data data = new Message.Data();

    @Override
    protected Message.Data getData() {
        return data;
    }

    MessageCheckMail() {
        super.setup(Protocol.CMD_CHECK_MAIL);
    }
}
