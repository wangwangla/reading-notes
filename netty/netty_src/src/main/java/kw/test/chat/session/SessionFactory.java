package kw.test.chat.session;

public abstract class SessionFactory {
    private static Session session = new SessionMemoryImpl();
}
