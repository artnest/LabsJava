package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageLetter extends Message {
    private static final long serialVersionUID = 1L;

    private String text;

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
        return "MessageLetter{" +
                "text='" + text + '\'' +
                ", data=" + data +
                '}';
    }
}
