package kw.test.chat.message;

public class AbstractResponseMessage extends Message{
    private boolean success;
    private String reason;

    public AbstractResponseMessage() {
    }

    public AbstractResponseMessage(boolean success, String reason) {
        this.success = success;
        this.reason = reason;
    }

    public boolean isSuccess() {
        return success;
    }


    @Override
    public int getMessageType() {
        return 0;
    }

    @Override
    public String toString() {
        return "AbstractResponseMessage{" +
                "success=" + success +
                ", reason='" + reason + '\'' +
                '}';
    }
}
