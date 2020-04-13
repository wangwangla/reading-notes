package com.company;

/**
 * 说明：
 *  接口是可以有静态方法和默认方法的
 */
public interface Demo04 {
    default int test(){
        return 1;
    }

    public static void fun(){

    }
    //会报错
    //protected void test1();
    //必须需要实现
//    default void f();
}
