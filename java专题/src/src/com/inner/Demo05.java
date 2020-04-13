package com.inner;

/**
 * 匿名内部类
 *  匿名内部类如果有参数的构造，那么就可以通过传入合适的参数来完成
 *
 *  匿名内部类的成员变量
 *  内部类如果需要传入一个外部的对象，那么就会将参数变为一个final,也就是初始化之后不会发生改变
 */
public class Demo05 {
    public Father contents() {
        return new Father() { // Insert class definition

        }; // Semicolon required
    }

    //上面的是实现类似于  应该是一样的
    class My implements Father{

    }

    public Father getIntance(){
        return new My();
    }

    public Father contents(DemoTest str) {
        return new Father() { // Insert class definition
            private DemoTest string = str;

        }; // Semicolon required
    }
}

class DemoTest{

}
