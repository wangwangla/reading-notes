package com.demo;

public class Demo01 {
    public static void method(int arr[],int K){
        //1.创建dp 从0开始，一直取值到k;
        int dp[] = new int[K+1];
        //初始值
        dp[0] = 0;
        //需要取最小值，所以存入最大值
        for (int i = 1; i <= K; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                //保证dp[i-arr[j]]不会越界
                if (arr[j]<=i){
                    //这个是可以组成的
                    if (dp[i-arr[j]]!=Integer.MAX_VALUE){
                        //取当前值 使得总数最少。
                        dp[i] = Math.min(dp[i],dp[i-arr[j]]+1);
                    }
                }
            }
        }
        //最后一个为最小值
        System.out.println(dp[K]);
    }

    public static void main(String[] args) {
        int arr[] = {
                2,5,7
        };
        int count = 27;
        method(arr,count);
    }
}
