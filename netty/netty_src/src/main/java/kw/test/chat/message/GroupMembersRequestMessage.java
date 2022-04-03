package kw.test.chat.message;

public class GroupMembersRequestMessage extends Message {
    private String groupName;

    public GroupMembersRequestMessage(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public int getMessageType() {
        return 0;
    }
}
