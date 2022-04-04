package kw.test.chat.session;

import kw.test.chat.handler.GroupSession;

public class GroupSessionFactory{

    private static GroupSession session = new GroupSessionMemoryImpl();

    public static GroupSession getGroupSession() {
        return session;
    }

}
