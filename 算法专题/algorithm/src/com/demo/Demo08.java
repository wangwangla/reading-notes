package com.demo;

public class Demo08 {
    public void method(int arr[][]){
        if (arr==null)return;
        int n = arr.length;
        int m = arr[0].length;
        int dp [][] = new int[n+1][m];
        dp[0][0] = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //求出小和最小
            }
            for (int k = 0; k < m; k++) {
                if (k == min1){
                    dp[i][k] = dp[i-1][min2]+arr[i][k];
                }else {
                    dp[i][k] = dp[i-1][min1]+arr[i][k];
                }
            }
        }
    }
}
