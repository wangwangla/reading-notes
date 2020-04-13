package com.fanxing.Demo;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        //这个时候，数据类型都是Object的
        ArrayList arrayList = new ArrayList();
        arrayList.add("java");
        arrayList.add(123);
        for (Object o : arrayList) {
            //但是类型都是需要使用的，这样的Object无法满足需求
            //可以使用强制类型转换，但是数据的类型不是需要转换的，如果无法转换就会出现异常的现象
        }


//        java提供了泛型，可以在编译的时候避免掉一些问题


    }
}
