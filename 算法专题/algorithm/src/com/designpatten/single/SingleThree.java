package com.designpatten.single;

public class SingleThree {
    public static void main(String[] args) {

    }
}


//这种方式可以防止反序列化
enum Singleton4{
    singleton;
//    private Singleton singleton = new Singleton() ;
}