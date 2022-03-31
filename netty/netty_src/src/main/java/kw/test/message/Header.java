package kw.test.message;

import java.util.HashMap;
import java.util.Map;

public class Header {
    private int crcCode = 0xabef0101;
    private int length;
    private long sessionId;
    private byte type;
    private byte priority;
    private Map<String,Object> attachMent = new HashMap<>();
}
