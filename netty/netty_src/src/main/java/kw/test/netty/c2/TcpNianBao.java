package kw.test.netty.c2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

import kw.test.log.KLog;
import kw.test.log.NettyLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * tcp传输的是在channel中的流，流是没有边界的，所以至于分成几个消息就只能通过缓存区的大小进行拆分
 *
 * 有可能一个被分为多个，  有可能多个被认为是一个
 *
 * 拆包：
 * - 应用程序写入的自己大小大于套接字发送缓存区的大小
 * - 进行MSS大小的TCP分段
 * - 以太网的payload大于MTU进行的ip分片
 *
 *
 * 解决方法：
 * - 消息定长
 * - 包尾加分隔符
 * 消息分为头 体 尾
 */
public class TcpNianBao {
    static final Logger log = LoggerFactory.getLogger(TcpNianBao.class);

    public static void main(String[] args) throws InterruptedException {
            new NettyLog();
            NioEventLoopGroup boss = new NioEventLoopGroup();
            NioEventLoopGroup worker = new NioEventLoopGroup();
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss,worker);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new Handler1());
            bootstrap.bind(8888).sync();
        }
    }

    class Handler1 extends ChannelInitializer<NioSocketChannel>{

        @Override
        protected void initChannel(NioSocketChannel ch) throws Exception {
            KLog.info("server init","connect");
//            ch.pipeline().addLast(new FixedLengthFrameDecoder(8));
            ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer("_".getBytes())));
            ch.pipeline().addLast(new StringDecoder());

            ch.pipeline().addLast(new TimerHandler1());
            ch.pipeline().addLast(new ChannelOutboundHandlerAdapter(){
                @Override
                public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                    super.write(ctx, msg, promise);
                    ByteBuf buffer = ctx.alloc().buffer();
                    buffer.writeBytes("iisiiis".getBytes());
                    ctx.writeAndFlush(buffer);
                }
            });
        }
    }


    class TimerHandler1 extends SimpleChannelInboundHandler {
        int count = 0;

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(msg);
            ctx.writeAndFlush("buffer");
            System.out.println("------------------------------------"+count++);
//        System.out.println("------------------------------msg");
//        ByteBuf byteBuf = (ByteBuf) msg;
//        byte[] bytes = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(bytes);
//        System.out.println(byteBuf.toString());
//        ctx.writeAndFlush(msg);
        }

    }
