package com.designpatten.yuanxing.chuantong;

import com.designpatten.yuanxing.chuantong.bean.People;

public class MainApp {
    public static void main(String[] args) {
        People people = new People("",1);
        People people1 = new People(people.getName(),people.getAge());
        People people2 = new People(people.getName(),people.getAge());
        People people3 = new People(people.getName(),people.getAge());
        People people4 = new People(people.getName(),people.getAge());
        People people5 = new People(people.getName(),people.getAge());
        People people6 = new People(people.getName(),people.getAge());
        System.out.println(people.toString());
        System.out.println(people1.toString());

        System.out.println(people2.toString());

        System.out.println(people3.toString());

        System.out.println(people4.toString());

        System.out.println(people5.toString());

        System.out.println(people6.toString());
    }
}
