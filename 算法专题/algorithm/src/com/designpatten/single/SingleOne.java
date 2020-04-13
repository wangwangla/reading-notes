package com.designpatten.single;

/**
 * 静态方法
 */
public class SingleOne {
    public static void main(String[] args) {

    }
}
//
///**
// * 没有实现懒加载，虽然解决了多线程的问题，可能会造成浪费。
// */
//class Singleton{
//    //1.构造器私有
//    private Singleton(){}
//    //创建实例
//    private final static Singleton instance = new Singleton();
//    //返回实例
//    public static Singleton getInstance() {
//        return instance;
//    }
//}
//


/**
 * 没有实现懒加载，虽然解决了多线程的问题，可能会造成浪费。
 */
class Singleton{
    //1.构造器私有
    private Singleton(){}
    //创建实例
    private final static Singleton instance;
    static {
        instance = new Singleton();
    }
    //返回实例
    public static Singleton getInstance() {
        return instance;
    }
}



