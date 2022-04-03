package kw.test.chat.message;

public class GroupQuitRequestMessage extends Message {
    private String groupName;
    private String userName;

    public GroupQuitRequestMessage(String groupName,String userName){
        this.groupName = groupName;
        this.userName = userName;
    }


    public String getGroupName() {
        return groupName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public int getMessageType() {
        return GroupQuitRequestMessage;
    }
}
