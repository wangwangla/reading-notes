package kw.test.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import kw.test.chat.message.GroupChatRequestMessage;
import kw.test.chat.message.GroupChatResponseMessage;
import kw.test.chat.session.GroupSessionFactory;

import java.util.List;

public class GroupChatRequestMessageHandler extends SimpleChannelInboundHandler<GroupChatRequestMessage> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupChatRequestMessage msg) throws Exception {
        List<Channel> membersChannel = GroupSessionFactory.getGroupSession().getMembersChannel(msg.getGroupName());
        for (Channel channel : membersChannel) {
            channel.writeAndFlush(new GroupChatResponseMessage(msg.getFrom(),msg.getContent()));
        }
    }
}
