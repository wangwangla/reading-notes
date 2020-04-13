package com.fanxing.cachu;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
//        ArrayList<String> strList = new ArrayList<>();
//        ArrayList<Integer> intList =  new ArrayList<>();
//        //区别就是一个带包名，一个不带包名。
//        System.out.println("strList.getName  :"+strList.getClass().getName()
//                + "===  strList.getSimpleName  :"+strList.getClass().getSimpleName());
//        //strList.getName  :java.util.ArrayList===  strList.getSimpleName  :ArrayList
//        //泛型编译之后泛型的类型就会被擦除，仅仅是在编译时期存在，后续就不会存在

        Class<People> peopleClass = People.class;
        Field[] fields = peopleClass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("name    :"+fields[i].getName()+"\n类型    :"+fields[i].getType());
        }
//        name    :name
//        类型    :class java.lang.Object
//        如果给People一个上限，那么最后的数据类型就是上限

    }
}
