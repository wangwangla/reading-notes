package kw.test.netty.c4;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;

public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        SerializableDemo demo = (SerializableDemo) msg;
        System.out.println(demo.toString());
        ctx.writeAndFlush(res());
    }

    private SerializableDemo res() {
        SerializableDemo demo = new SerializableDemo();
        demo.setAge(11);
        demo.setName("kw");
        return demo;
    }
}
