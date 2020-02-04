package kw.test.demo;

public class Demo02 {
    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        System.out.println(demo01);
    }
}

class Demo01{
    public String toString(){
        System.out.println("===========");
        return "xxx";
    }
}
