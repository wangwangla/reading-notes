package com.designpatten.yuanze.lishiyuanze;

public class Demo {
    public static void main(String[] args) {

    }
}

class A{
    public int method(int x,int y){
        return x+y;
    }
}

class B extends A{
    @Override
    public int method(int x, int y) {
        return x- y;
    }

    public void method2(int num1,int num2){
        System.out.println(method(num1,num2)+9);
    }
}


//改进   使用组合
abstract class Base{
    public abstract int method(int x,int y);
}

class AVersiin2 extends Base{
    public int method(int x,int y){
        return x+y;
    }
}


class BVersion2 extends Base{
    private AVersiin2 a;
    @Override
    public int method(int x, int y) {
        return x- y;
    }

    public void method2(int num1,int num2){
        System.out.println(a.method(num1,num2)+9);
    }
}

