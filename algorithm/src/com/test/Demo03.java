package com.test;

public class Demo03 {
//    private String name;
//    private int age;
//    private String address;
//
//    public void prinInfo() {
//        System.out.printf("name:"+name+"age:"+age+"address："+address);
//    }

    private Info info;
    public Demo03(){
        info = new Info();
    }
    public void printInfo(){
        info.getInfo();
    }
}

class Info{
    private String name;
    private int age;
    private String address;
    public void getInfo() {
        System.out.printf("name:"+name+"age:"+age+"address："+address);
    }

}