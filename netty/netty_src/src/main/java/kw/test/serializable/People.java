package kw.test.serializable;

import io.netty.buffer.ByteBuf;

import java.io.Serializable;
import java.nio.ByteBuffer;

public class People implements Serializable {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte[] code(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = this.name.getBytes();
        byteBuffer.putInt(bytes.length);
        byteBuffer.put(bytes);
        byteBuffer.putInt(this.age);
        byteBuffer.flip();
        bytes = null;
        byte[] res = new byte[byteBuffer.remaining()];
        byteBuffer.get(res);
        return res;
    }
}
