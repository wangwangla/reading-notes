package com.designpatten.yuanxing.yuanxing.bean;

import com.designpatten.yuanxing.yuanxing.bean.People;

public class MainApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        People people = new People("",1);
        People people1 = (People) people.clone();
        System.out.println(people1.toString());
    }
}
