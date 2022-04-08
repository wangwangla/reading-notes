package kw.test.framedecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import kw.test.chat.protocol.ProcotolFrameDecoder;

public class FrameDecoderClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ProcotolFrameDecoder());
                        ch.pipeline().addLast(new StringEncoder());
                        ch.pipeline().addLast(new StringDecoder());
//                        ch.pipeline().addLast(new ChannelOutboundHandlerAdapter(){
//                            @Override
//                            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//                                super.write(ctx, msg, promise);
//                                System.out.println("out");
//                            }
//                        });
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                super.channelActive(ctx);

                                StringBuilder b = new StringBuilder();
                                for (int i = 0; i < 1000; i++) {
                                    b.append(1);
                                }
                                ctx.writeAndFlush(b.toString());

                            }

                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                super.channelRead(ctx, msg);

                                System.out.println(msg);
                            }
                        });
                    }
                }).connect("127.0.0.1",8889).sync();
    }

}
