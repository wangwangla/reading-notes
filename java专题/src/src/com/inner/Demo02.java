package com.inner;

import com.company.Demo04;

/**
 * 内部类可以使用其他类的接口
 * 内部类可以使用外部类的成员变量。
 */

public class Demo02 {
    private int num = 1;
    //可以使用外部的接口   这个迭代器就是这么实现的
    class Demo021 implements Demo04 {
        public void prin(){
            //可以使用外部的成员变量   内部类可以调用外围类的成员变量
            System.out.println("num = " + num);
        }

        //得到外部类的实例，使用this得到
        public Demo02 getIntance(){
            Demo02 demo02 = Demo02.this;
            return demo02;
        }
    }

    public Demo021 getDemo021(){
        return new Demo021();
    }
    public static void main(String[] args) {
        //获取外围的
        Demo02 demo02 = new Demo02();
        //获取内部类的
        Demo02.Demo021 demo021 = demo02.getDemo021();
        //获取外部类的
        demo021.getIntance();

        //创建内部类的方法   只有当外部类有了实例，才会有内部类的出现
        Demo02 demo022 = new Demo02();
        Demo02.Demo021 demo0211 = demo022.new Demo021();
    }
}
