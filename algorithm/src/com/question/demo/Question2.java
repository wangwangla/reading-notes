package com.question.demo;

/**
 * 找出数组中落单的数据
 */
public class Question2 {
    public static void main(String[] args) {
        int arr[] = {0,4,2,3,2,4,5,6,3,5,6};
        sou1(arr);
    }

    public static void sou1(int arr[]){

        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            x = x^arr[i];
        }
        System.out.println(x+"");
    }
}
