package kw.test.chat.message;

public class GroupQuitResponseMessage extends AbstractResponseMessage {
    public GroupQuitResponseMessage(boolean success, String reason) {
        super(success, reason);
    }

    @Override
    public int getMessageType() {
        return GroupQuitResponseMessage;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}