package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageContextResult")
@XmlRootElement(name = "MessageContextResult")
class MessageContextResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
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
