package kw.test.message;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

import java.util.List;

public class NettyMessageEncoder extends MessageToMessageEncoder<Message> {
    private MarshallingEncoder marshallingEncoder;
    public NettyMessageEncoder(){
//        this.marshallingEncoder = new MarshallingEncoder();
    }
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {

    }
}
