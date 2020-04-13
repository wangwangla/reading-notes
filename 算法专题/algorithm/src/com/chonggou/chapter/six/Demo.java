package com.chonggou.chapter.six;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {

    }
    /*********************************************************/
    /****************************提炼函数**********************/
    /*********************************************************/
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
        printWelcome();

//        打印价钱是有局部变量的
//        System.out.printf("price"+price);
        printPrice(price);
    //我认为这里还有一个不妥的即使还给传入变量进行了赋值。
//        name += "wang";
//        printName(name);
        printName(name+"wang");
    }

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


    /*********************************************************/
    /****************************内联函数**********************/
    /*********************************************************/
    /**
     * 一个函数可以移动变为一个函数
     * @return
     */
    public boolean getBoolean(){
        return getNum()>5?true:false;
    }

    private int getNum() {
        return 5;
    }

    //neilian
    public boolean getBoolean1(){
        return 5>5?true:false;
    }

    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /**************************内联临时变量********************/
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /**
     * double price  = instance.getPrice();
     * return price>3.0F;
     *
     * return instance.getPrice()>3.0F
     */


    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /*******************使用查询取代临时变量********************/
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    private int _price = 100;
    private int num = 4;
    public double getTotal(){
//        double priceAll = _price*num;
//        if (priceAll>10){
//            return priceAll*=0.5F;
//        }else {
//            return priceAll*=0.8F;
//        }


//        if (getPrice() > 10){
//            return getPrice()*0.5F;
//        }else {
//            return getPrice()*0.8F;
//        }

        return getPrice()*lilv();
    }

    public double getPrice(){
        return _price*num;
    }

    public double lilv (){
        if (getPrice()>10){
            return 0.5F;
        }else {
            return 0.8F;
        }
    }
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /**********************引入解释性变量**********************/
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    public void jieshi(String name,String age){
//        if ("kang".equals(name)&&age.equals("28")){
//            return;
//        }

        boolean isNameCommon = "kang".equals(name);
        boolean isAgeCommon = "28".equals(age);
        if (isNameCommon&&isAgeCommon){
            return;
        }
    }


    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /**********************分解临时变量**********************/
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    private void fenjie(){
//        float price = 100;
//        System.out.println(price);
//        price = 10;
//        System.out.println(price);
//

        float price = 100;
        System.out.printf("price"+price);
        float price1 = 10;
        System.out.println(price1);
    }

    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /**********************移除对参数赋值**********************/
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    private void fuzhi(String name){
//        if ("".equals(name)){
//            name = "kang";
//        }
//        System.out.println(name);
//


//        为什么，如果是有一个值传递，应该是没有什么的，如果是一个对象，也就意味着修改了这个对象的值
        String result ;
        result = name;
        if ("".equals(name)){
            result = "kang";
        }
    }
//  完整案例
//    public class Demo02 {
//        public static void main(String[] args) {
//            com.test.Demo02 demo02 = new com.test.Demo02();
//            com.test.People kang = new com.test.People("kang", 12);
//            demo02.ceshi(kang);
//            System.out.printf(""+kang);
//            int i = 3;
//            demo02.ceshi1(i);
//            System.out.printf("i   "+ i);
//        }
//        public void ceshi(com.test.People people){
//            people.setAge(29);
//        }
//        public void ceshi1(int i){
//            i = 0;
//        }
//
//    }
//    class People{
//        private String name;
//        private int age;
//
//        People(String name,int age){
//            this.name = name;
//            this.age =  age;
//        }
//        public int getAge() {
//            return age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public String toString() {
//            return "People{" +
//                    "name='" + name + '\'' +
//                    ", age=" + age +
//                    '}';
//        }
//    }
//


    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /*********************以函数对象取代函数********************/
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    //完整案例
//
//    public class Demo03 {
////    private String name;
////    private int age;
////    private String address;
////
////    public void prinInfo() {
////        System.out.printf("name:"+name+"age:"+age+"address："+address);
////    }
//
//        private com.test.Info info;
//        public Demo03(){
//            info = new com.test.Info();
//        }
//        public void printInfo(){
//            info.getInfo();
//        }
//    }
//
//    class Info{
//        private String name;
//        private int age;
//        private String address;
//        public void getInfo() {
//            System.out.printf("name:"+name+"age:"+age+"address："+address);
//        }
//
//    }


    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    /**************************替换算法************************/
    /*********************************************************/
    /*********************************************************/
    /*********************************************************/
    public void find(String name){
//        if ("J".equals(name)){
//
//        }
//        if ("H".equals(name)){
//
//        }
//        if ("B".equals(name)){
//
//        }

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("J");
        arrayList.add("H");
        arrayList.add("B");
        if (arrayList.contains(name)){

        };
    }
}
