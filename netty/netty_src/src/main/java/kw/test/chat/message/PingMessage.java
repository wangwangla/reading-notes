package kw.test.chat.message;

import kw.test.chat.message.Message;

public class PingMessage extends Message {
    @Override
    public int getMessageType() {
        return PingMessage;
    }
}
