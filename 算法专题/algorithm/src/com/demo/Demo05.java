package com.demo;

public class Demo05 {
    public void method(String s){
        //字母为length为0，返回为1
        char[] chars = s.toCharArray();
        //dp
        int length = chars.length;
        int dp[] = new int[length+1];
        dp [0] = 0;
        int num = 0;
        for (int i = 1; i < length; i++) {
            if (chars[i]!=0) {
                dp[i] = dp[i - 1] + 1;
            }
            if (i>1){
                // 1 2 34  5
                num = chars[i-1]+chars[i-1]*10;
                if (num <26 && num>9){
                    dp[i] = dp[i]+1;
                }
            }
        }
    }
}
