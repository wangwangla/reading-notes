package kw.test.chat.message;

public class GroupJoinResponseMessage extends AbstractResponseMessage {
    public GroupJoinResponseMessage(boolean success,String reason){
        super(success,reason);
    }

    @Override
    public int getMessageType() {
        return GroupJoinResponseMessage;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
