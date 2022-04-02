package kw.test.chat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kw.test.chat.message.LoginRequestMessage;
import kw.test.chat.message.LoginResponseMessage;
import kw.test.chat.service.UserService;
import kw.test.chat.service.UserServiceFactory;

public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        String username = msg.getUsername();
        String password = msg.getPassword();
        UserService userService = UserServiceFactory.getUserService();
        boolean login = userService.login(username, password);
        LoginResponseMessage message;
        if (login){
See
        }
    }
}
