package homework.lab10;

import java.io.Serializable;

public class MessageResult extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    private int errorCode;
    private String errorMessage;

    public int getErrorCode() {
        return errorCode;
    }

    public boolean error() {
        return errorCode != Protocol.RESULT_CODE_OK;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    protected MessageResult() {
        super();
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