package kw.test.demo;

import io.netty.buffer.ByteBuf;
import kw.test.chat.config.Config;
import kw.test.chat.protocol.Serializer;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;

public class App {
    public static void main(String[] args) {
//        byte[] bytes1 = int2byte(200);
//        for (int i = 0; i < bytes1.length; i++) {
//            System.out.println(bytes1[i]);
//        }
//        System.out.println(byte2int(bytes1));
//        byteWrite();
//        test();
        read();

//        int i = 100;
//        int i1 = i >> 1&1;
//        int i2 = i >>2&1;
//        int i3 = i >>3&1;
//        int i4 = i >>4&1;
//        int i5 = i >>5&1;
//        int i6 = i >>6&1;
//        int i7 = i >>7&1;
//        System.out.println(i1+"  "+i2+"  "+ i3+" "+
//                i4+"  "+i5+"  "+ i6+" "+i7);
//


    }

    public  static void test() {
        File file = new File("words_tree.dat");
        try(
                FileInputStream stream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
        ) {
            byte[] b = new byte[1];
            int count = 0;
            while (bufferedInputStream.read(b) != -1) {

                System.out.println(count+"---"+b[0]+"------"+(char)b[0]);
                count++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    public static void read() {
        try {
            InputStream n = new FileInputStream(new File("words_tree.dat"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = n.read(bArr);
                if (read < 0) {
                    n.close();
                    byte[] bytes = byteArrayOutputStream.toByteArray();
                    ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
                    allocate.put(bytes);
                    System.out.println("-----------------");
                    allocate.flip();
                    for (int i = 0; i < 83; i++) {
                        System.out.println((char) allocate.get());
                    }
                    char aChar = allocate.getChar();
                    System.out.println("----------------------");


//                    m40259C(bytes);
//                    ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
//                    for (int i = 0; i < 83; i++) {
//                        System.out.print(inputStream.read());
//                    }
//                    System.out.println("-------------");
//                    byte[] ss = new byte[4];
//                    while (inputStream.read(ss,0,4)!=-1){
//                        System.out.print(byte2int(ss)+" ");
//                    }

//                    for (int i = 0; i < bytes.length; i++) {
//                        System.out.println(i+"  "+bytes[i]+"  "+(char)bytes[i]);
//                        if (i==300){
//                            System.out.println("----------------");
//                        }
//                    }
//
//                    C14012x6 c14012x6 = new C14012x6();
//                    c14012x6.mo70752i(bytes.length);
//                    c14012x6.mo70750g(bytes);
//                    m39531i(c14012x6,bytes);
//                    m40259C(bytes);
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sss(byte[] b){

    }

    private static String m40259C(byte[] bArr) {
        int i;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i2 = -1;
        int i3 = length > 0 ? bArr[0] & 255 : -1;
        int i4 = length > 1 ? bArr[1] & 255 : -1;
        int i5 = 2;
        if (i3 == 254 && i4 == 255) {
            while (i5 < length - 1) {
                int i6 = i5 + 1;
                i5 = i6 + 1;
                sb.append((char) ((bArr[i6] & 255) | ((bArr[i5] & 255) << 8)));
            }
        } else if (i3 == 255 && i4 == 254) {
            while (i5 < length - 1) {
                int i7 = i5 + 1;
                i5 = i7 + 1;
                sb.append((char) (((bArr[i7] & 255) << 8) | (bArr[i5] & 255)));
            }
        } else {
            if (length > 2) {
                i2 = bArr[2] & 255;
            }
            int i8 = (i3 == 239 && i4 == 187 && i2 == 191) ? 3 : 0;
            while (true) {
                if (i8 >= length) {
                    break;
                }
                int i9 = i8 + 1;
                int i10 = bArr[i8] & 255;
                if ((i10 & 128) != 0) {
                    if ((i10 & 224) != 192) {
//                        public static final int VIDEO_STREAM_MASK = 240;
//
                        if ((i10 & 240) != 224 || (i = i9 + 1) >= length || (bArr[i9] & -64) != 128 || (192 & bArr[i]) != 128) {
                            break;
                        }
                        i10 = ((i10 & 15) << 12) | ((bArr[i9] & 63) << 6) | (bArr[i] & 63);
                        i9 += 2;
                    } else if (i9 >= length || (bArr[i9] & -64) != 128) {
                        break;
                    } else {
                        i10 = ((i10 & 31) << 6) | (bArr[i9] & 63);
                        i9++;
                    }
                }
                sb.append((char) i10);
                i8 = i9;
            }
            z = true;
            if (z) {
                return m40260D(bArr);
            }
        }
        return sb.toString();
    }

    /* renamed from: D */
    private  static String m40260D(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        try (    FileWriter file = new FileWriter("test.txt");
        ){
            file.write(new String(cArr));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(cArr);
    }


    /* renamed from: i */
    public static int m39531i(C14012x6 x6Var, byte[] bytes) {
//        m39540r();
        if (x6Var != null) {
            int f34501h = 3;
            String str = "";
            int i = 0;
            for (int i2 = 0; i2 < x6Var.mo70744a(); i2++) {
                String p = x6Var.mo76739p(i2, 1, "utf8");
                str = str + p;
                if (p.compareTo("{") != 0) {
                    if (p.compareTo("}") == 0 && i - 1 == 0) {
                        break;
                    }
                } else {
                    i++;
                }
            }
            System.out.println(str);

            System.out.println("----------------------------------");














//
//
//
//
//
//
//
//
//            int length = str.length();
//            C13786r8 r8Var = new C13786r8();
//            r8Var.mo75150m(str);
//            C13632n8 w = r8Var.mo75160w("of");
//            int v = r8Var.mo75160w("dl").mo73985v(0, 0);
//            C13632n8 w2 = r8Var.mo75160w("uc");
//            C13786r8 B = r8Var.mo75135B("cm");
//            if (w2 == null || B == null) {
//                int []f34499f = new int[26];
//                C13619mx mxVar = new C13619mx();
//                mxVar.mo73890j();
//                C13619mx f34500g = mxVar;
//                int f34496c = 1;
//                for (int i3 = 0; i3 < 26; i3++) {
//                    int i4 = i3 + 97;
//                    f34499f[i3] = i4;
////                    f34500g.mo75410h(i4, i3);
////                    f34500g.mo75410h(oi0.m44605l(i4), i3);
//                }
//            } else {
//                int i5 = 0;
//                for (int i6 = 0; i6 < w2.mo73988y(); i6++) {
//                    int v2 = w2.mo73985v(i6, 0);
//                    if (v2 > i5) {
//                        i5 = v2;
//                    }
//                }
//                int[] iArr = new int[w2.mo73988y()];
//                int []f34499f = iArr;
//                int f34496c = (m45675e(iArr) / 32) + 1;
//                for (int i7 = 0; i7 < w2.mo73988y(); i7++) {
//                    f34499f[i7] = w2.mo73985v(i7, 0);
//                }
//                C13619mx mxVar2 = new C13619mx();
//                mxVar2.mo73890j();
//                C13619mx f34500g = mxVar2;
////                C13963vy b = B.mo75139F().mo77168b();
////                while (b.mo76326b()) {
////                    String c = b.mo76327c();
////                    f34500g.mo75410h(Integer.parseInt(c.trim()), B.mo75134A(c, 0));
////                }
//            }
////            f34495b = new int[w.mo73988y()];
////            for (int i8 = 0; i8 < w.mo73988y(); i8++) {
////                f34495b[i8] = w.mo73985v(i8, 0);
////            }
////            int[] iArr2 = new int[v];
////            f34497d = iArr2;
////            x6Var.mo70748e(length, iArr2, 0, v);
            return 0;
        }
//        f34501h = 1;
        return 0;
    }
    static int m45675e(Object obj) {
        if (obj != null) {
            return Array.getLength(obj);
        }
        return 0;
    }


//    static int[] f34505l;
//
//    /* renamed from: r */
//    public static int m39540r() {
//        int[]f34495b = new int[16];
//        int []f34498e = new int[8192];
//        for (int i = 0; i < 8192; i++) {
//            int[] iArr = f34498e;
//            int[] iArr2 = f34505l;
//            iArr[i] = iArr2[i & 15];
//            if (i >= 16) {
//                int i2 = i >> 4;
//                iArr[i] = iArr[i] + iArr2[i2 & 15];
//                if (i >= 256) {
//                    int i3 = i2 >> 4;
//                    iArr[i] = iArr[i] + iArr2[i3 & 15];
//                    if (i >= 4096) {
//                        iArr[i] = iArr[i] + iArr2[(i3 >> 4) & 15];
//                    }
//                }
//            }
//        }
//        return 0;
//    }
//
//



    public static void byteWrite(){
//        byte[] bytes = new byte[2048];
//        for (int i = 0; i < 200; i++) {
//            bytes[i] = (byte) i;
//        }
//        System.out.println("=========================");
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        int i = 1000;
        String str = "str";
        allocate.putInt(i);
        allocate.putChar('a');
        allocate.putInt('0');
        allocate.putInt(str.length());
        for (int i1 = 0; i1 < str.length(); i1++) {
            allocate.putChar(str.charAt(i1));
        }
        System.out.println("-------------------------");
    }

    public void testConfig(){
        Serializer.Algorithm serializerAlgorithm = Config.getSerializerAlgorithm();
        System.out.println(serializerAlgorithm);
    }

    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];

        targets[0] = (byte) (res & 0xff);// 最低位
        targets[1] = (byte) ((res >> 8) & 0xff);// 次低位
        targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
        targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
        return targets;
    }

    public static int byte2int(byte[] res) {
        // 一个byte数据左移24位变成0x??000000，再右移8位变成0x00??0000
        int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | 表示安位或
                | ((res[2] << 24) >>> 8) | (res[3] << 24);
        return targets;
    }


//
//
//    public final String mo75386b(int length) {
//
//        while (this.f38169c < this.f38168b.length() && this.f38168b.charAt(this.f38169c) <= ' ') {
//            this.f38169c++;
//        }
//        if (this.f38169c == this.f38168b.length()) {
//            this.f38170d = "";
//            this.f38171e = 0;
//            return "";
//        }
//        int i = this.f38169c;
//        int f = mo75390f();
//        if (f == 34) {
//            while (true) {
//                int f2 = mo75390f();
//                if (f2 == 34) {
//                    break;
//                } else if (f2 == 92) {
//                    mo75390f();
//                }
//            }
//            this.f38171e = 1;
//        } else if (f == 39) {
//            while (true) {
//                int f3 = mo75390f();
//                if (f3 == 39) {
//                    break;
//                } else if (f3 == 92) {
//                    mo75390f();
//                }
//            }
//            this.f38171e = 1;
//        } else if (f == 45 || (f >= 48 && f <= 57)) {
//            if (f != 45 || ((f = mo75390f()) >= 48 && f <= 57)) {
//                if (f != 48) {
//                    mo75389e();
//                }
//                if (mo75388d(46)) {
//                    mo75389e();
//                }
//                if (mo75388d(69) || mo75388d(101)) {
//                    if (mo75398n() == 43 || mo75398n() == 45) {
//                        mo75390f();
//                    }
//                    if (!mo75389e()) {
//                        mo75393i("Bump.chr=e or E CParseDigits");
//                        return "";
//                    }
//                }
//                this.f38171e = 2;
//            } else {
//                mo75393i("Bump.chr=45 " + String.valueOf((char) f));
//                return "";
//            }
//        } else if ((f < 65 || f >= 91) && (f < 97 || f >= 123)) {
//            this.f38171e = 3;
//        } else {
//            int n = mo75398n();
//            while (true) {
//                if ((n < 65 || n >= 91) && (n < 97 || n >= 123)) {
//                    this.f38171e = 4;
//                } else {
//                    mo75390f();
//                    n = mo75398n();
//                }
//            }
//            this.f38171e = 4;
//        }
//        String k = C13779r1.m45681k(this.f38168b, i, this.f38169c);
//        this.f38170d = k;
//        return k;
//    }
//


}
