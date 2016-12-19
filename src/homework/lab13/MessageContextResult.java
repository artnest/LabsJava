package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageContextResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    public MessageResult.Data data = new MessageResult.Data();

    public MessageContextResult() {
        super.setup(Protocol.CMD_CONTEXT);
    }

    public MessageContextResult(String errorMessage) {
        super.setup(Protocol.CMD_CONTEXT, errorMessage);
    }

    public MessageResult.Data getData() {
        return data;
    }
}
