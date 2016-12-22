package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MessageConnectResult", propOrder = {
        "data"
}, namespace = "MessageConnectResult")
@XmlRootElement
class MessageConnectResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    public MessageResult.Data data = new MessageResult.Data();

    MessageConnectResult(String errorMessage) { // error
        super.setup(Protocol.CMD_CONNECT, errorMessage);
    }

    MessageConnectResult() { // No error
        super.setup(Protocol.CMD_CONNECT);
    }

    @Override
    public MessageResult.Data getData() {
        return data;
    }
}
