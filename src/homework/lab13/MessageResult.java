package homework.lab13;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

abstract class MessageResult extends MessageXml {

    static class Data implements Serializable {
        private static final long serialVersionUID = 1L;

        protected byte id;
        private int errorCode;
        private String errorMessage;

        @XmlAttribute
        public byte getID() {
            return id;
        }

        public void setID(byte id) {
            assert Protocol.validID(id);
            this.id = id;
        }

        @XmlAttribute
        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public boolean error() {
            return errorCode != Protocol.RESULT_CODE_OK;
        }

        @XmlAttribute
        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        @Override
        public String toString() {
            return id + ", " + errorCode + ", " + errorMessage;
        }
    }

    private static final long serialVersionUID = 1L;

    protected MessageResult() {
    }

    protected abstract MessageResult.Data getData();

    int getErrorCode() {
        return getData().getErrorCode();
    }

    boolean error() {
        return getData().error();
    }

    String getErrorMessage() {
        return getData().getErrorMessage();
    }

    protected void setup(byte id, String errorMessage) {
        getData().setID(id);
        getData().setErrorCode(Protocol.RESULT_CODE_ERROR);
        getData().setErrorMessage(errorMessage);
    }

    protected void setup(byte id) {
        getData().setID(id);
        getData().setErrorCode(Protocol.RESULT_CODE_OK);
        getData().setErrorMessage("");
    }

    @Override
    public String toString() {
        return getData().toString();
    }
}
