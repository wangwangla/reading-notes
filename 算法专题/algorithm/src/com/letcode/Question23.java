package com.letcode;

/**
 * 针对纯字符可以使用
 */
public class Question23 {
    public static  int lengthOfLongestSubstring(String s) {
        if (s.equals(""))return 0;
        int chars[] = new int[26];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = -1;
        }
        char[]arr = s.toCharArray();
        int ch;
        int [] f = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ch = arr[i] - 'a';
            if (chars[ch]==-1) {
                chars[ch] = i;
                if (i==0){
                    f[i] = 1;
                }else {
                    f[i] = f[i - 1] + 1;
                }
            }else {
                f[i] = i-chars[ch];
                chars[ch] = i;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < f.length; i++) {
            if (max < f[i]){
                max = f[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "asdfgjhk";
        lengthOfLongestSubstring(s);
    }
}
