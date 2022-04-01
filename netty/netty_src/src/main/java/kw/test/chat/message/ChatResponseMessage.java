package kw.test.chat.message;

public class ChatResponseMessage extends Message {
    @Override
    public int getMessageType() {
        return ChatRequestMessage;
    }
}
