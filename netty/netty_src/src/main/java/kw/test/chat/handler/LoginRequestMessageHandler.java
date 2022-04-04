package kw.test.chat.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kw.test.chat.message.LoginRequestMessage;
import kw.test.chat.message.LoginResponseMessage;
import kw.test.chat.service.UserService;
import kw.test.chat.service.UserServiceFactory;
import kw.test.chat.session.SessionFactory;

@ChannelHandler.Sharable
public class LoginRequestMessageHandler extends SimpleChannelInboundHandler<LoginRequestMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestMessage msg) throws Exception {
        System.out.println("------------------------------------");
        String username = msg.getUsername();
        String password = msg.getPassword();
        UserService userService = UserServiceFactory.getUserService();
        boolean login = userService.login(username, password);
        LoginResponseMessage message;
        System.out.println(login+"000000000000000000");
        if (login){
            SessionFactory.getSession().bind(ctx.channel(),username);
            message =new LoginResponseMessage(true,"成功！");
        }else {
            message = new LoginResponseMessage(false,"失败！");
        }
        ctx.writeAndFlush(message);
    }
}
