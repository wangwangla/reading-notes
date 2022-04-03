package kw.test.chat.message;

import kw.test.chat.handler.GroupSession;

import java.nio.channels.Channel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GroupSessionMemoryImpl implements GroupSession {
    private final Map<String,Group> groupMap = new ConcurrentHashMap<>();

    @Override
    public Group createGroup(String name, Set<String> members) {
        Group group = new Group(name,members);
        return groupMap.putIfAbsent(name,group);
    }

    @Override
    public Group joinMember(String name, String member) {
        return null;
    }

    @Override
    public Group removeMember(String name, String member) {
        return null;
    }

    @Override
    public Set<String> getMembers(String name) {
        return null;
    }

    @Override
    public List<Channel> getMembersChannel(String name) {
        return null;
    }
}
