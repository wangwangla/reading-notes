package kw.test.chat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kw.test.chat.session.Group;
import kw.test.chat.message.GroupJoinResponseMessage;
import kw.test.chat.message.GroupQuitRequestMessage;
import kw.test.chat.session.GroupSessionFactory;

public class GroupQuitRequestMessageHandler extends SimpleChannelInboundHandler<GroupQuitRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupQuitRequestMessage msg) throws Exception {
        Group group = GroupSessionFactory.getGroupSession().removeMember(msg.getGroupName(), msg.getUserName());

        if (group != null){
            ctx.writeAndFlush(new GroupJoinResponseMessage(true,"退出"+msg.getGroupName()));
        }else {
            ctx.writeAndFlush(new GroupJoinResponseMessage(true,msg.getGroupName()+"不存在"));
        }
    }
}
