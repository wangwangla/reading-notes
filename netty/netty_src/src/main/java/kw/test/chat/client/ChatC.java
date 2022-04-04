package kw.test.chat.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import kw.test.chat.message.LoginRequestMessage;
import kw.test.chat.message.LoginResponseMessage;
import kw.test.chat.message.Message;
import kw.test.chat.message.MessageCodecSharable;
import kw.test.chat.protocol.ProcotolFrameDecoder;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChatC {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(MESSAGE_CODEC);
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);
                                Message message = new LoginResponseMessage(true,"123455");
                                ctx.writeAndFlush(message);
                            }
                        });
                        ch.pipeline().addLast(new ProcotolFrameDecoder());
                    }
                });

        Channel channel = bootstrap.connect("localhost", 8888).sync().channel();
        channel.closeFuture().sync();
    }
}
