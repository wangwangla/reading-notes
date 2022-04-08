package kw.test.bytedemo;

import oracle.jrockit.jfr.events.Bits;

import java.nio.ByteBuffer;

public class App {
    public static void main(String[] args) {
        //他是对byte的一个封装
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte b = 'a';
        byteBuffer.put(b);


        byteBuffer.putInt(3);

//        Bits bits =
    }
}
