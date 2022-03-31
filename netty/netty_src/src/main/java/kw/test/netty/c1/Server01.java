package kw.test.netty.c1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import kw.test.log.KLog;
import kw.test.log.NettyLog;

public class Server01 {
    public static void main(String[] args) throws InterruptedException {
        new NettyLog();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss,worker);
        bootstrap.channel(NioServerSocketChannel.class);

        bootstrap.childHandler(new Handler());
        bootstrap.bind(8888).sync();
    }
}

class Handler extends ChannelInitializer<NioSocketChannel>{

    @Override
    protected void initChannel(NioSocketChannel ch) throws Exception {
        KLog.info("server init","connect");
        ch.pipeline().addLast(new StringDecoder());
        ch.pipeline().addLast(new TimerHandler());
        ch.pipeline().addLast(new OutHandler());
    }
}

/**
 * 接受信息的    信息变为String
 */
class TimerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        System.out.println(msg);
        ByteBuf buffer = ctx.alloc().buffer();
        buffer.writeBytes(new byte[]{'h','i'});
        ctx.writeAndFlush(buffer);

    }

//    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println(msg);
//        ByteBuf buffer = ctx.alloc().buffer();
//        buffer.writeBytes(new byte[]{'h','i'});
//        ctx.writeAndFlush(buffer);
//    }

    class SipleTimerHandler extends SimpleChannelInboundHandler {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(msg);
            ByteBuf buffer = ctx.alloc().buffer();
            buffer.writeBytes(new byte[]{'h', 'i'});
            ctx.writeAndFlush(buffer);
//        System.out.println("------------------------------msg");
//        ByteBuf byteBuf = (ByteBuf) msg;
//        byte[] bytes = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(bytes);
//        System.out.println(byteBuf.toString());
//        ctx.writeAndFlush(msg);
        }
    }
}
