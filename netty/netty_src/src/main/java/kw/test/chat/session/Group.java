package kw.test.chat.session;

import java.util.Collections;
import java.util.Set;

public class Group {
    private String name;
    private Set<String> members;
    public static final Group EMPTY_GROUP = new Group("empty", Collections.emptySet());

    public String getName() {
        return name;
    }

    public Set<String> getMembers() {
        return members;
    }

    public Group(String name, Set<String> emptySet) {
        this.name = name;
        this.members = emptySet;
    }
}
