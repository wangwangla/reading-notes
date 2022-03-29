package kw.test.netty.c1;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import kw.test.log.KLog;
import kw.test.log.NettyLog;

import java.net.InetSocketAddress;
import java.util.Date;

public class Clent01 {
    public static void main(String[] args) {
        new NettyLog();
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        ChannelFuture connect = null;
        try {
            connect = new Bootstrap().group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel ch) throws Exception {
                            KLog.info("client init","connect");
                            ch.pipeline().addLast(new StringEncoder());
                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    super.channelRead(ctx, msg);
                                    System.out.println(msg);
                                }
                            });
                        }
                    }).connect("127.0.0.1", 8888).sync();
            Channel channel = connect.channel();
            channel.writeAndFlush(new Date() + ": hello world!"); // 7
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

        }
    }

//    public static void main(String[] args) {
//        try {
////            new Bootstrap()
////                    .group(new NioEventLoopGroup()) // 1.创建客户端循环方式
////                    .channel(NioSocketChannel.class) // 2.使用的通道
////                    .handler(new ChannelInitializer<Channel>() { // 3.初始化处理器
////                        @Override
////                        protected void initChannel(Channel ch) {
////                            ch.pipeline().addLast(new StringEncoder()); // 8，字节转换为字符串
////                        }
////                    })
////                    .connect("127.0.0.1", 8888) // 4
//
//            new Bootstrap().group(new NioEventLoopGroup())
//                    .channel(NioSocketChannel.class)
//                    .handler(new ChannelInitializer<Channel>() {
//                        @Override
//                        protected void initChannel(Channel ch) {
//                            KLog.info("client init","connect");
//                            ch.pipeline().addLast(new StringEncoder());
//                        }
//                    }).connect("127.0.0.1", 8888).sync() // 5
//                    .channel() // 6
//                    .writeAndFlush(new Date() + ": hello world!"); // 7
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
