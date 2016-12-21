package homework.lab13;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;

// TODO fix XML generation
@XmlType(name = "MessageUserResult", propOrder = {
        "userNicks",
        "data"
})
@XmlRootElement(name = "MessageUserResult")
class MessageUserResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    @XmlElement(required = true)
    private String[] userNicks = null;

    String[] getUserNicks() {
        return userNicks;
    }

    @XmlElement(required = true)
    public MessageResult.Data data = new MessageResult.Data();

    MessageUserResult(String errorMessage) { // error
        super.setup(Protocol.CMD_USER, errorMessage);
    }

    MessageUserResult(String[] userNicks) { // No errors
        super.setup(Protocol.CMD_USER);
        this.userNicks = userNicks;
    }

    @Override
    public MessageResult.Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Users: " + Arrays.toString(userNicks) +
                "; " + data;
    }
}
