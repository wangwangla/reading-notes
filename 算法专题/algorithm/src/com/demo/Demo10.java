package com.demo;

public class Demo10 {
    public void mathod(int weight[],int value[],int K){
        int n  = weight.length;
        int dp[][] = new int[n][n];
        dp[0][0] = 0;
        //取得的重量
        for (int k = 1; k < K; k++) {
            //遍历价值
            for (int w = 0; w < n; w++) {
                if (k>=weight[w]){
                //    dp[k][w] =
                }
            }
        }

    }
}
