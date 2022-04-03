package kw.test.chat.handler;

import io.netty.channel.Channel;
import kw.test.chat.message.Group;

import java.util.List;
import java.util.Set;

public interface GroupSession {
    /**
     * 创建一个聊天组   如果不存在就创建
     * @param name
     * @param members
     * @return
     */
    Group createGroup(String name, Set<String> members);

    /**
     * 加入群组
     * @param name
     * @param member
     * @return
     */
    Group joinMember(String name,String member);

    Group removeMember(String name,String member);

    Set<String> getMembers(String name);

    List<Channel> getMembersChannel(String name);

}
