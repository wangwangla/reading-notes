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

    @Override
    public int getMessageType() {
        return 0;
    }
}
