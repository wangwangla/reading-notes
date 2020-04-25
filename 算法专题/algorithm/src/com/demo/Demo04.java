package com.demo;

public class Demo04 {
    public void method(int [][]arr){
        //获取到房子数目
        int n = arr.length;
        //颜色
        int K = arr[0].length;
        //我们从第一个房子到最后一个房子
        int dp[][] = new int[n+1][K];
        //初始值
        dp[0][0] = 0;
        //n个房子
        for (int i = 1; i < n + 1; i++) {
            //shang房子染色为j
            for (int j = 0; j < K; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //dangqian一个为k
                for (int  k= 0; k < K; K++) {
                    if (j!=k){
                        if (dp[i-1][j]+arr[i-1][k]<dp[i][j]){
                            dp[i][j] = dp[i-1][j]+arr[i-1][k];
                         }
                    }
                }
            }
        }
    }
}
