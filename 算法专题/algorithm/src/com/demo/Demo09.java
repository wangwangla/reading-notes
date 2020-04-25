package com.demo;

public class Demo09 {
    public static void method(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = dp[i - j * j] + 1;
            }
        }

        System.out.println(
                dp[n]
        );

    }

    public static void main(String[] args) {
        method(
                13
        );
    }
}
