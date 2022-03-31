package kw.test.netty.c4;

import io.netty.channel.*;
import io.netty.util.concurrent.EventExecutorGroup;

public class SubReqClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        System.out.println("----------------------------------");


        SerializableDemo demo = new SerializableDemo();
        demo.setName("kk");
        demo.setAge(11);
        ctx.writeAndFlush(demo);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println(msg);
    }
}
