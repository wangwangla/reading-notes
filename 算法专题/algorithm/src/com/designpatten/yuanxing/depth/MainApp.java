package com.designpatten.yuanxing.depth;

import com.designpatten.yuanxing.depth.bean.MyString;
import com.designpatten.yuanxing.depth.bean.People;

public class MainApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        People people = new People("wang",1,new MyString("test"));
        People people1 = people.clone();
        System.out.println(people1.toString());
        //当我对非基本数据类型进行修改，两个对象都发生了修改，说明了他们指向的是同一个对象。
        people.getString().setStr("ee");
        people.setName("chen");
        System.out.println(people.toString()+"\n"+people1.toString());
    }
}
