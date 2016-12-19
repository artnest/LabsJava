package homework.lab13;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class MessageCheckMailResult extends MessageResult {
    private static final long serialVersionUID = 1L;

    private String[] letters = null;
    public MessageResult.Data data = new MessageResult.Data();

    String[] getLetters() {
        return letters;
    }

    MessageCheckMailResult(String errorMessage) { // error
        super.setup(Protocol.CMD_CHECK_MAIL, errorMessage);
    }

    MessageCheckMailResult(String[] letters) { // No errors
        super.setup(Protocol.CMD_CHECK_MAIL);
        this.letters = letters;
    }

    @Override
    protected MessageResult.Data getData() {
        return data;
    }

    @Override
    public String toString() {
        String result = super.toString();
        if (letters != null) {
            for (String str : letters) {
                result += ", " + str;
            }
        }

        return result;
    }
}
