package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement
class MessageUserResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    private String[] userNicks = null;

    String[] getUserNicks() {
        return userNicks;
    }
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
        return "MessageUserResult{" +
                "userNicks=" + Arrays.toString(userNicks) +
                ", data=" + data +
                '}';
    }
}
