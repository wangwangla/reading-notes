package com.javaeight;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为参数传地代码,这种方式可以方便的处理判断条件发生变化的情况，我们可以使用下面的方法进行优化，但是
 * 这种方式，莫名其妙的多了折磨多的实现，我们在对其进行优化
 */
public class CDCS {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        CDCS cdcs = new CDCS();
        cdcs.demo(list,new Weight());
        //一次优化，但是比较啰嗦，我们使用Lambda
        cdcs.demo2(list, new Filter() {
            @Override
            public boolean test(Apple apple) {
                return apple.getPrice()>10;
            }
        });

        //lambda
        cdcs.demo2(list,(Apple apple)->apple.getPrice()>10);
        //将他们进行类型抽象化


    }

    public void demo(List<Apple> list,Filter filter){
        for (Apple apple : list) {
            if(filter.test(apple)){
                System.out.printf("-------");;
            }
        }
    }

    public void demo2(List<Apple> list, Filter filter){
        for (Apple apple : list) {
            if (filter.test(apple)){
                System.out.printf("--------");
            }
        }
    }

}

interface Filter{
    public boolean test(Apple apple);
}

class Weight implements Filter{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>10;
    }
}

class price implements Filter{
    @Override
    public boolean test(Apple apple) {
        return apple.getPrice()>10;
    }
}


class Apple{
    private int weight;
    private int price;

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }
}
