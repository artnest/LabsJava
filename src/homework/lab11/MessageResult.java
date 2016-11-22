package homework.lab11;

import java.io.Serializable;

class MessageResult extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private int errorCode;
    private String errorMessage;

    int getErrorCode() {
        return errorCode;
    }

    boolean error() {
        return errorCode != Protocol.RESULT_CODE_OK;
    }

    String getErrorMessage() {
        return errorMessage;
    }

    protected MessageResult(byte id, String errorMessage) {
        super(id);
        this.errorCode = Protocol.RESULT_CODE_ERROR;
        this.errorMessage = errorMessage;
    }

    protected MessageResult(byte id) {
        super(id);
        this.errorCode = Protocol.RESULT_CODE_OK;
        this.errorMessage = "";
    }
}
