package com.letcode;

/**
 * @author:28188
 * @date: 2021/3/7
 * @time: 14:58
 */
public class Question30 {
    public static void main(String[] args) {
         String ss = "PAYPALISHIRING";
//         numRows = 3
//        输出："PAHNAPLSIIGYIR";
        convert(ss,3);
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 )return null;
        int i = s.length() / numRows;
//            for (int i2 = 0; i2 < numRows; i2++) {
//                if (i2+i1*i<s.length())
//                System.out.println(s.charAt(i2+i1*i));
//            }
        for (int i2 = 0; i2 < numRows; i2++) {
            for (int i1 = 0; i1 <= i; i1++) {
                if (i*i1+i2<s.length()){
                    System.out.print(s.charAt(i*i1+i2));
                }
                if (i2!=0&&i2!=numRows-1){
                    int i3 = i1 * i + i2 + 2 * (numRows - i2 - 1);
                    if (i3<s.length()){
                        System.out.print(s.charAt(i3));
                    }
                }
            }
            System.out.println();
        }
        s.charAt(i);
        return null;
    }

    /**
     * @author:28188
     * @date: 2021/3/7
     * @time: 14:58
     */
    public static String convert1(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] chars = new char[s.length()];
        int colLen = 2 * numRows - 2;  //每列的长度
        if(colLen==0) colLen=1;
        int n = s.length();
        int index;
        int minCol = n / colLen;   //共有多少完整列
        int ci = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < minCol + 1; j++) {
                index = j * colLen + i;
                if (index < s.length()) {
                    chars[ci++] = s.charAt(index);
                }
                if (i != 0 && i != numRows - 1) {
                    index = j * colLen + i + 2 * (numRows - i - 1);
                    if (index < s.length())
                        chars[ci++] = s.charAt(index);
                }
            }
        }
        return String.valueOf(chars);
    }
}


//PAHN
// APLSIIG
// YIR