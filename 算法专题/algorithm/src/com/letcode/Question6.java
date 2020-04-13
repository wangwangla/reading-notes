package com.letcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 */
public class Question6 {
    /**
     * 一个一个进行比较
     * @param str1
     * @param str2
     */
    public static void method1(String str1 ,String str2){
        Map<Character,String> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            map.put(str1.charAt(i),null);
        }
        for (int i = 0; i < str2.length(); i++) {
            if (!map.containsKey(str2.charAt(i))){
                System.out.println("error");
                return;
            }
        }
        System.out.println("true");
    }

    public static void main(String[] args) {
        String str1 = "abdkskhhdr";
        String str2 = "rhk";
        method1(str1,str2);
    }
}
