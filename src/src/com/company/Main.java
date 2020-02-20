package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Vector vector = new Vector();
//        vector.add("1");
//        vector.add("2");
//        Object arr[] = new Object[10];
//        vector.copyInto(arr);
//        for (int i = 0; i < vector.size(); i++) {
//
//        }
//        System.out.println(arr[0]);
//
//        vector.trimToSize();
//
//        vector.setSize(14);
//
//        System.out.println(vector.size());
//        System.out.println(vector.capacity());
//
//        vector.get(0);
//        vector.elements();
//
//        vector.get(-1);

//        int arr[] = {1,32,2,1,2};
//        int temp[] = new int[arr.length];
//
//        System.arraycopy(arr,0,temp,2,1);
//        System.out.println("================");
//        for (int i = 0; i < temp.length; i++) {
//            System.out.println(temp[i]);
//        }
//
//
        Vector vector = new Vector();
        vector.add(1);
        vector.add(2);

        int a = 10;
        System.out.println(a+"============");
        a = a + (a >> 1);
        System.out.println(a+"new");
    }
}
