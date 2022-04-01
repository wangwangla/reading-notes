package kw.test.chat.message;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToMessageCodec;

public class MessageCodecSharable extends MessageToMessageCodec<ByteBuf, Message> {
}
