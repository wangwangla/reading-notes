package com.algorithm.dongtaiguihua;

import java.io.IOException;

public class Question2 {
    /**
     * 偷东西 不能偷相邻的
     */


    /**
     * 买股票，那一天卖出获得的利润最大
     */
    public int maxLiRun1(int prices[]){
        if (prices.length==0){
            return 0;
        }
        int length = prices.length;
        int f[] = new int[length];
        f[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            f[i] = 0;//卖入   买出
            f[i] = Math.max(f[i-1],prices[i]-min);
            if (min >prices[i]){
                min = prices[i];
            }
        }
        return f[length-1];
    }
    /**
     * 可以有多天进行买卖
     */
    public void maxLiRun(int arr[]){
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i-1]){
                max += arr[i-1] - arr[i];
            }
        }
    }       

    /**
     * 只可以有两次买卖
     */
    public int maxLiRun3(int arr[]){
        return 0;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("=========");
        System.in.read();
    }
}
