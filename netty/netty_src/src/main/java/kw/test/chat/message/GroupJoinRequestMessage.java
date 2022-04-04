package kw.test.chat.message;

public class GroupJoinRequestMessage extends Message {
    private String groupName;
    private String username;

    public GroupJoinRequestMessage(String username, String groupName){
        this.groupName = groupName;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getGroupName() {
        return groupName;
    }

    @Override
    public int getMessageType() {
        return 0;
    }

    @Override
    public String toString() {
        return "GroupJoinRequestMessage{" +
                "groupName='" + groupName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
