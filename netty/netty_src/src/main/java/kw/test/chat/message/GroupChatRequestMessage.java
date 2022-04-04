package kw.test.chat.message;


public class GroupChatRequestMessage extends Message {

    private String content;
    private String groupName;
    private String from;

    public GroupChatRequestMessage(String from,String groupName,String content){
        this.content  = content;
        this.groupName = groupName;
        this.from = from;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getContent() {
        return content;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public int getMessageType() {
        return GroupChatResponseMessage;
    }

    @Override
    public String toString() {
        return "GroupChatRequestMessage{" +
                "content='" + content + '\'' +
                ", groupName='" + groupName + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}
