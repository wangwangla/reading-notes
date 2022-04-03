package kw.test.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kw.test.chat.message.Group;
import kw.test.chat.message.GroupCreateRequestMessage;
import kw.test.chat.message.GroupCreateResponseMessage;
import kw.test.chat.message.GroupSessionFactory;

import java.util.List;
import java.util.Set;

public class GroupCreateRequestMessageHandler extends SimpleChannelInboundHandler<GroupCreateRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupCreateRequestMessage msg) throws Exception {
        String groupName = msg.getGroupName();
        Set<String> members = msg.getMembers();

        GroupSession groupSession = GroupSessionFactory.getGroupSession();
        Group group = groupSession.createGroup(groupName,members);
        if (group == null){
            ctx.writeAndFlush(new GroupCreateResponseMessage(true,groupName+"创建成功"));
            List<Channel> channels = groupSession.getMembersChannel(groupName);
            for (Channel channel : channels) {
                channel.writeAndFlush(new GroupCreateResponseMessage(true,"已经进入群聊"));
            }
        }else {
            ctx.writeAndFlush(new GroupCreateResponseMessage(false,groupName+"存在"));
        }
    }
}
