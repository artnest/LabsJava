package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// TODO fix XML generation
@XmlType(name = "MessageLetter", propOrder = {
        "text",
        "data"
}, namespace = "MessageLetter")
@XmlRootElement(name = "MessageLetter")
class MessageLetter extends Message {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    private String text;

    @XmlElement(required = true)
    public Message.Data data = new Message.Data();

    String getText() {
        return text;
    }

    MessageLetter(String text) {
        super.setup(Protocol.CMD_LETTER);
        this.text = text;
    }

    @Override
    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return text + ", " + data;
    }
}
