package kw.test.chat.message;

public class GroupJoinResponseMessage extends AbstractResponseMessage {
    public GroupJoinResponseMessage(boolean success,String reason){
        super(success,reason);
    }
}
