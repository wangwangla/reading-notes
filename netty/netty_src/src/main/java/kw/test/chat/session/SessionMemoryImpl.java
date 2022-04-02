package kw.test.chat.session;

import io.netty.channel.Channel;

public class SessionMemoryImpl implements Session {

    @Override
    public void bind(Channel channel, String username) {

    }

    @Override
    public void unbind(Channel channel) {

    }

    @Override
    public Object getAttribute(Channel channel, String name) {
        return null;
    }

    @Override
    public void setAttribute(Channel channel, String name, Object value) {

    }

    @Override
    public Channel getChannel(String username) {
        return null;
    }
}
