package com.test;

public class Demo01 {
    public static void main(String[] args) {
        String str = "90001";
        System.out.printf("print  "+str.substring(str.length()-2,str.length()));
        int i = Integer.parseInt(str.substring(str.length()-2,str.length()));
        System.out.printf("==="+i);
    }
}
