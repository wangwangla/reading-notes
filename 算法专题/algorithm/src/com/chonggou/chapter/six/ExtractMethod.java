package com.chonggou.chapter.six;

public class ExtractMethod {
    /**
     * 提炼函数分为三种情况
     * - 没有参数的，直接创建函数就可以，将他们移进去就完事了。
     * - 有参数，参数需要返回吗，不需要就直接传入，需要还需要将其返回
     * - 有局部变量，局部变量可以一起移入新函数中吗？
     * @param price
     * @param name
     */
    public void println(int price,String name){
//        System.out.println("welcome learn");
//        System.out.println("my name is kw");

//        打印价钱是有局部变量的
//        System.out.printf("price"+price);

        //我认为这里还有一个不妥的即使还给传入变量进行了赋值。
//        name += "wang";
//        printName(name);


        printWelcome();
        printPrice(price);
        printName(name+"wang");
    }

    //有参数
    private void printName(String name) {
        System.out.println("name:"+name);
    }

    //提炼
    private void printWelcome(){
        System.out.println("welcome learn");
        System.out.println("my name is kw");
    }

    private void printPrice(int price){
        System.out.printf("price"+price);
    }
}
