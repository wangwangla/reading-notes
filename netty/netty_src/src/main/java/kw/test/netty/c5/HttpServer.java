package kw.test.netty.c5;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.EventExecutor;

public class HttpServer {
    private static final String DEFAULT_URL = "/src/";

    public static void main(String[] args) throws InterruptedException {
        new ServerBootstrap()
            .group(new NioEventLoopGroup())
            .channel(NioServerSocketChannel.class)
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    System.out.println("---------------------");
//                    ch.pipeline().addLast("http-decodet",new HttpRequestDecoder());
//                    ch.pipeline().addLast("http-aggregator",new HttpObjectAggregator(65535));
//                    ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());
                    ch.pipeline().addLast(new HttpServerCodec());
                    ch.pipeline().addLast(new HttpFileServerHandler(DEFAULT_URL));

                }
            }).bind(8888).sync();
    }
}
