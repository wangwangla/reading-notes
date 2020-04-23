package com.algorithm.dongtaiguihua;

/**
 * 背包
 * 1.n个物体
 * 2.每个物体的重量是nv……
 * 3.包的承重是m
 * 4.求出最大多少重量
 */
public class Question5 {
    public void soul(int M,int m[],int v[]){
        //我们创建数组，将重量进行罗列
        int dp[] = new int[M+1];
        for (int i = 0; i < M + 1; i++) {
            dp[i] = 0;
        }
        //一共有n个物品  加入取i个物品的时候，可以得到的最大重量。
        for (int i = 0; i < m.length; i++) {
            for (int j = M; j >= 0; j--) {
                if (j>m[i]){
                    dp[j] = Math.min(dp[j],dp[j-m[i-1]]+v[i-1]);
                }
            }
        }
    }
}
