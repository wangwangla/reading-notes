package com.jianxiansiqi;


import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import javax.lang.model.util.Elements;
import java.util.*;

/**
 * 阅读源码，每读一个写一行
 */
public class Main {
    public static void main(String[] args) {
	// write your code here
        //Number
       // Number number = 2;
        //number.byteValue();
        //System.out.println(number.doubleValue());
        //String string = "";

     //   Number number1 = 255;
        //Integer i = 0;
        //Number number = 0;
        //Integer.toString(398);
        //System.out.println(Integer.toString(10));
        //int test = 8;
        //int x = (test*52429)>>>19;
        //System.out.println((test * 52429) >>> (16+3));
//        System.out.println(1<0);
//        ArrayList list = (ArrayList) Arrays.asList(1,2,3);
//        list.add(4);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//        new Random(30)
//                .ints(5,20)
//                .distinct()
//                .limit(7)
//                .sorted()
//                .forEach(System.out::println);
//
        Vector vector = new Vector();
        vector.add(1);
        vector.add(1);
        vector.add(1);
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.get(i));
        }
        //枚举器
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }


    }
}










