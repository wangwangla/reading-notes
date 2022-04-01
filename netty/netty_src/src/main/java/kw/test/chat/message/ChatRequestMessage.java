package kw.test.chat.message;

public class ChatRequestMessage extends Message {
    @Override
    public int getMessageType() {
        return ChatRequestMessage;
    }
}
