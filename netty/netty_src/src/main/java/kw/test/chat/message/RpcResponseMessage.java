package kw.test.chat.message;

public class RpcResponseMessage extends Message {
    @Override
    public int getMessageType() {
        return RPC_MESSAGE_TYPE_RESPONSE;
    }
}
