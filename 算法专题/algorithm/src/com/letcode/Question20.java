package com.letcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 */
public class Question20 {
    public static void main(String[] args) {
        climbStairs(3);
    }
    public static int climbStairs(int n) {
        int pre = 0;
        int preT = 0;
        int temp = 0;
        for (int i = 0; i <= n; i++) {
            if (i==0||i==1){
                pre = 1;
                preT = 1;
            }else {
                temp = pre;
                pre = pre + preT;
                preT = temp;
            }
        }
        return pre;
    }


    public void c2(int n){
        class Solution {
            public int climbStairs(int n) {
                int f[] = new int[n+1];

                for (int i = 0; i <= n; i++) {
                    if (i==0||i==1){
                        f[i] = 1;
                    }else {
                        f[i] = f[i-1]+f[i-2];
                    }
                }
                return f[n];
            }
        }
    }
}
