package com.company;

public class Demo05 implements Demo04,Demo06 {
    public static void main(String[] args) {
        Demo05 demo05 = new Demo05();
        System.out.println(demo05.test());

    }

    @Override
    public int test() {
        return Demo06.super.test();
    }


    //    @Override
//    public int test() {
//        return 0;
//    }
}
