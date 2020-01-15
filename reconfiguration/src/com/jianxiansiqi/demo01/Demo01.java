package com.jianxiansiqi.demo01;

public class Demo01 {
    public void demo01(){
        //无参数传递的重构
        System.out.println("=============");
        System.out.println("====title====");
        System.out.println("=============");
        //有参数   参数留在方法中，不需要返回
        int count = 0 ;
        count = count + 1;
        //有参数，参数需要后续使用
        int sum = 1;
        sum += 3;

        int total = sum + 2;
        //-------------
        showBanner();
        noReturn();
        havePar();
    }

    public int havePar(){
        int sum = 1;
        sum += 3;
        return sum;
    }

    public void noReturn(){
        int count = 0 ;
        count = count + 1;
        System.out.println(count);
    }


    public void showBanner(){
        System.out.println("=============");
        System.out.println("====title====");
        System.out.println("=============");
    }
}
