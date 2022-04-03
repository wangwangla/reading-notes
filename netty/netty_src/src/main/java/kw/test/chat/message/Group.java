package kw.test.chat.message;

import java.util.Collections;
import java.util.Set;

public class Group {
    private String name;
    private Set<String> members;
    public static final Group EMPTY_GROUP = new Group("empty", Collections.emptySet());

    public Group(String name, Set<String> emptySet) {
        this.name = name;
        this.members = emptySet;
    }
}
