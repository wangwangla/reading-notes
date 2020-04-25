package com.demo;

public class Demo07 {
    public void method(int arr[][]){
        if (arr == null){
            return;
        }
        if (arr.length == 0){
            return;
        }
        int dp [][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (i==0||j == 0){
                    dp[i][j] = arr[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
}
