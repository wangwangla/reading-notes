package kw.test.netty.c4;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class SerializeClient {
    public static void main(String[] args) throws Exception {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ObjectDecoder(
                                1024,
                                ClassResolvers.cacheDisabled(this.getClass().getClassLoader())
                        ));
                        ch.pipeline().addLast(new ObjectEncoder());
                        ch.pipeline().addLast(new SubReqClientHandler());
                    }
                }).connect("127.0.0.1",8888).sync();

    }

}
