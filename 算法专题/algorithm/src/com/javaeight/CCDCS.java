package com.javaeight;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数传地代码,这种方式可以方便的处理判断条件发生变化的情况，我们可以使用下面的方法进行优化，但是
 * 这种方式，莫名其妙的多了折磨多的实现，我们在对其进行优化
 */
public class CCDCS<T> {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        CCDCS<Apple> cdcs = new CCDCS<>();
        cdcs.demo(list, (Apple apple)->apple.getPrice()>10);
    }

    public void demo(List<T> list,Filter1<T> t){
        for (T t1 : list) {
            if(t.test(t1)){
                System.out.println("======");
            }
        }
    }
}

interface Filter1<T>{
    public boolean test(T t);
}



class Apple1{
    private int weight;
    private int price;

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
