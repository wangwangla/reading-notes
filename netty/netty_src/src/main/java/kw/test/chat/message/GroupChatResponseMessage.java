package kw.test.chat.message;

public class GroupChatResponseMessage extends AbstractResponseMessage {
    private String from;
    private String content;

    public String getFrom() {
        return from;
    }

    public String getContent() {
        return content;
    }

    public GroupChatResponseMessage(String from,String content){
        this.content = content;
        this.from = from;
    }

    @Override
    public int getMessageType() {
        return GroupChatResponseMessage;
    }
}
