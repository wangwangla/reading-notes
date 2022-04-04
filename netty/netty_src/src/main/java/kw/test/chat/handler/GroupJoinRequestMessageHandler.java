package kw.test.chat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kw.test.chat.session.Group;
import kw.test.chat.message.GroupJoinRequestMessage;
import kw.test.chat.message.GroupJoinResponseMessage;
import kw.test.chat.session.GroupSessionFactory;

public class GroupJoinRequestMessageHandler extends SimpleChannelInboundHandler<GroupJoinRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupJoinRequestMessage msg) throws Exception {
        Group group = GroupSessionFactory.getGroupSession().joinMember(msg.getGroupName(), msg.getUsername());
        if (group != null){
            ctx.writeAndFlush(new GroupJoinResponseMessage(true,msg.getGroupName()+"加入"));
        }else {
            ctx.writeAndFlush(new GroupJoinResponseMessage(true,msg.getGroupName()+" 创建"));
        }
    }
}
