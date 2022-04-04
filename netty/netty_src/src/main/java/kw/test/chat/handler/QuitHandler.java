package kw.test.chat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import kw.test.chat.session.SessionFactory;

public class QuitHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        SessionFactory.getSession().unbind(ctx.channel());
        System.out.println(" disconnect ！");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        SessionFactory.getSession().unbind(ctx.channel());
    }
}
