package kw.test.serializable;

import java.io.*;

/**
 * java 提供了ObjectInputStream和ObjectOutputStream
 * 直接讲java对象存储到文件中
 *
 * 也可以在网络上传输
 *
 * 跨进程使用的时候就需要讲java对象变为字节数组或者ByteBuffer对象，
 *
 * java只能有一种
 *
 *
 * 缺点：
 * - 无法跨语言
 * - 码流大
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        People people = new People();
        people.setAge(10);
        people.setName("wangwang");
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileOutputStream bos = new FileOutputStream(new File("tsx"));
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(people);
        os.flush();
        os.close();
        bos.close();
    }
}
