package kw.test.chat.message;

public class GroupChatRequestMessage extends Message {
    @Override
    public int getMessageType() {
        return GroupChatResponseMessage;
    }
}
