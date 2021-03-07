package com.letcode;

import org.omg.CORBA.WCharSeqHelper;

/**
 * @author:28188
 * @date: 2021/3/7
 * @time: 15:54
 */
public class Question31 {
    public static void main(String[] args) {

    }
    public int myAtoi(String s) {
        s.toCharArray();
        int  index = 0;
        char [] aa = new char[s.length()];
        for (int i = 0; i < aa.length; i++) {
            char c = aa[i];
            if (c == '-'||c == '+' || c >= '0' || c<='9'){
                aa[index] = c;
                index++;
            }
        }

        int xx = 0;
        for (char c : aa) {

        }
        return 0;
    }
}
