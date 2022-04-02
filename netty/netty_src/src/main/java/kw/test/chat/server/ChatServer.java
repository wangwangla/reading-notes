package kw.test.chat.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import kw.test.chat.handler.*;
import kw.test.chat.message.MessageCodecSharable;
import kw.test.chat.protocol.ProcotolFrameDecoder;

public class ChatServer {
    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        LoggingHandler LOGGING_HANDLER = new LoggingHandler(LogLevel.DEBUG);
        MessageCodecSharable MESSAGE_CODEC = new MessageCodecSharable();
        LoginRequestMessageHandler LOGIN_HANDLER = new LoginRequestMessageHandler();
        ChatRequestMessageHandler CHAT_HANDLER = new ChatRequestMessageHandler();
        GroupCreateRequestMessageHandler GROUP_CREATE_HANDLER = new GroupCreateRequestMessageHandler();
        GroupJoinRequestMessageHandler GROUP_JOIN_HANDLER = new GroupJoinRequestMessageHandler();
        GroupMembersRequestMessageHandler GROUP_MEMBERS_HANDLER = new GroupMembersRequestMessageHandler();
        GroupQuitRequestMessageHandler GROUP_QUIT_HANDLER = new GroupQuitRequestMessageHandler();
        GroupChatRequestMessageHandler GROUP_CHAT_HANDLER = new GroupChatRequestMessageHandler();
        QuitHandler QUIT_HANDLER = new QuitHandler();


        try {
            ChannelFuture sync = new ServerBootstrap()
                    .group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ProcotolFrameDecoder());
                            ch.pipeline().addLast(LOGGING_HANDLER);
                            ch.pipeline().addLast(MESSAGE_CODEC);
                            // 用来判断是不是 读空闲时间过长，或 写空闲时间过长
                            // 5s 内如果没有收到 channel 的数据，会触发一个 IdleState#READER_IDLE 事件
                            ch.pipeline().addLast(new IdleStateHandler(5, 0, 0));
                            ch.pipeline().addLast(new ChannelDuplexHandler() {
                                // 用来触发特殊事件
                                @Override
                                public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception{
                                    IdleStateEvent event = (IdleStateEvent) evt;
                                    // 触发了读空闲事件
                                    if (event.state() == IdleState.READER_IDLE) {
//                                        log.debug("已经 5s 没有读到数据了");
                                        ctx.channel().close();
                                    }
                                }
                            });
                            ch.pipeline().addLast(LOGIN_HANDLER);
                            ch.pipeline().addLast(CHAT_HANDLER);
                            ch.pipeline().addLast(GROUP_CREATE_HANDLER);
                            ch.pipeline().addLast(GROUP_JOIN_HANDLER);
                            ch.pipeline().addLast(GROUP_MEMBERS_HANDLER);
                            ch.pipeline().addLast(GROUP_QUIT_HANDLER);
                            ch.pipeline().addLast(GROUP_CHAT_HANDLER);
                            ch.pipeline().addLast(QUIT_HANDLER);

                        }
                    }).bind(8888)
                    .sync();
            Channel channel = sync.channel();
            channel.closeFuture().sync();
        }catch (Exception e){

        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
