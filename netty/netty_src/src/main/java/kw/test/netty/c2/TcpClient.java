package kw.test.netty.c2;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import kw.test.log.KLog;
import kw.test.log.NettyLog;

import java.util.Date;

import static io.netty.buffer.ByteBufUtil.appendPrettyHexDump;
import static io.netty.util.internal.StringUtil.NEWLINE;

public class TcpClient {
    public static void main(String[] args) throws InterruptedException {
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
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    super.channelActive(ctx);
                                    //开始就执行的
                                }

                                @Override
                                public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                                    super.exceptionCaught(ctx, cause);
                                    System.out.println("----------shshhhh");
                                }

                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    super.channelRead(ctx, msg);
                                    ByteBuf buf = (ByteBuf)msg;
//                                    byte b = buf.readByte();
                                    for (int i = 0; i < 100; i++) {
                                        System.out.println("----------------------");
                                    }

                                    log(buf);
                                }

                            });
                            ch.pipeline().addLast(new ChannelOutboundHandlerAdapter(){
                                @Override
                                public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                                    super.write(ctx, msg, promise);

                                    System.out.println("---------------------");
                                    for (int i = 0; i < 100; i++) {
                                        ctx.writeAndFlush("xxxxxxxxxxxxxxxxxxxx_\n");
                                    }
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

    private static void log(ByteBuf buffer) {
        int length = buffer.readableBytes();
        int rows = length / 16 + (length % 15 == 0 ? 0 : 1) + 4;
        StringBuilder buf = new StringBuilder(rows * 80 * 2)
                .append("read index:").append(buffer.readerIndex())
                .append(" write index:").append(buffer.writerIndex())
                .append(" capacity:").append(buffer.capacity())
                .append(NEWLINE);
        appendPrettyHexDump(buf, buffer);
        System.out.println(buf.toString());
    }
}
