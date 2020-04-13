package com.inner;

/**
 * 内部类
 *
 * 运行将一些逻辑相关的类组织在一起，控制位于内部类的可见性，内部类和组合时两个概念
 * 简单就是将一个类放在一个类的里面，但是它于外部也可以进行通信
 *
 * 那么我们为什么需要使用内部类? 什么时候需要？
 *  - 最常见的就是迭代器中使用，
 *  - 内部类的使用和外部类的使用没有什么区别
 *  - 外部类的使用可以创建一个指向内部类的方法
 */
public class Demo01 {
    //create inner class
    static class Contensts{
        private int i = 11;
        public int value(){
            return i;
        }
    }

    class Dmeo02{
        private int x = 0;

        public int getX() {
            return x;
        }
    }
    //使用内部类和外部类一样没有什么特别的。
    public  void create(){
        Dmeo02 dmeo02 = new Dmeo02();
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
//        demo01.Contensts = new Demo01().Contensts;
//        Contensts contensts = new Demo01.Contensts();
        //create a instance
          Contensts contensts = new Contensts();
          demo01.create();

          //创建对象
          Demo01.Dmeo02 dmeo02 = demo01.getIns();
//          有问题
//          Demo01.Dmeo02 dmeo021 = new Demo01.Dmeo02();

    }

    /**
     * 外部类将有一个方法，该方法返回一个只想内部类的引用
     */
    public Dmeo02 getIns(){
        return new Dmeo02();
    }

    /**
     * 外部类可以使用外围函数的变量
     */

}
















