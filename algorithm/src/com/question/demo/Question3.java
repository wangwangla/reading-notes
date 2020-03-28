package com.question.demo;

/**
 * 找出二进制中为1的个数
 * 解题：
 *  - 可以与1进行与运算，结果为1的就为1，累加1的个数，原始的数组向右移动
 *  - 移动可以有两种，一种是移动1，一种是移动数据
 *  - （x-1）&x = 0;
 *
 */
public class Question3 {
    public static void main(String[] args) {
        sou2(10);
    }

    public static void sou1(int N){
        System.out.println(Integer.toBinaryString(N)+"");
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((N&(1<<i)) == (1<<i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void sou2(int N){
        int count = 0;
        while (N!=0){
            N = N&(N-1);  //n^(n-1) = 0
            count++;
        }
        System.out.println(count+"");
    }
}
