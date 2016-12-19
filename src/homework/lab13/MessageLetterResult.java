package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageLetterResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    public MessageResult.Data data = new MessageResult.Data();

    MessageLetterResult(String errorMessage) { //error
        super.setup(Protocol.CMD_LETTER, errorMessage);
    }

    MessageLetterResult() { // No errors
        super.setup(Protocol.CMD_LETTER);
    }

    @Override
    public MessageResult.Data getData() {
        return data;
    }
}
