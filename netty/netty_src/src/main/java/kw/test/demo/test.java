package kw.test.demo;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class test {
    public static void main(String[] args) {
        byte[] bytes = {-113,0,0,0};
        System.out.println(byte2int(bytes));
//        byte [] bx = {0,0,0,-113};
//        System.out.println(byte2int(bx));

    }

    public static int byte2int(byte[] res) {
        // 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
        int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | 表示安位或
                | ((res[2] << 24) >>> 8) | (res[3] << 24);
        return targets;
    }

    private static char[] getChars (byte[] bytes) {
        Charset cs = Charset.forName (String.valueOf(Charset.defaultCharset()));
        ByteBuffer bb = ByteBuffer.allocate (bytes.length);
        bb.put (bytes);
        bb.flip ();
        CharBuffer cb = cs.decode (bb);
        return cb.array();
    }

    public static char byteToChar(byte[] b) {
        char c = (char) (((b[0] & 0xFF) << 8) | (b[1] & 0xFF));
        System.out.println((int)c);
        return c;
    }

    public static char byteToChar1(byte[] b) {
        int hi = (b[0] & 0xFF) << 8;
        int lo = b[1] & 0xFF;
        return (char) (hi | lo);
    }
}
