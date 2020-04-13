package com.question.demo;

/**
 * 判断某个数，是不是2的次方数
 */
public class Question4 {
    public static void main(String[] args) {
        sou1(7);
    }
    public static void sou1(int N){
        if (((N)&(N-1))==0){
            System.out.println(""+true);
        }else {
            System.out.println("" + false);
        }
    }
}
