package com.letcode;

/**
 * @author:28188
 * @date: 2021/3/7
 * @time: 14:23
 */
public class Question29 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 解题方法：
     * - i从开始遍历到最后一个，但是并不是真正的遍历到最后一个  中间可以根据找到的情况在进行优化
     * @param args
     */
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    /**
     * 1.长度为null 和 0 直接返回
     * 2.从开始位置遍历到最后一个
     * 3.创建数组，用来存储开始位置和结束位置。
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest1(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }


    public static int findLongest1(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
//        当前和下一个相同   ……aa……
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

    public void longStr(String str){
        if (str == null || str.length() == 0)return;
        int range[] = new int[2];
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            i = find(chars,i,range);
        }
    }

    private int find(char[] str, int i, int[] range) {
        int high = i;
        while (high<str.length-1&&str[i] == str[high+1]){
            high++;
        }

        int sen = high;
        while (i>0&&high<str.length-1 && str[i-1] == str[high-1]){
            i--;
            high++;
        }

        if (high - i>range[1] - range[0]){
            range[0] = i;
            range[1] = high;
        }
        return sen;
    }

    //最可怕的解法，两个for
    public String longestPalindrome3(String s) {
        for(int l=s.length();l>0;l--){
            for(int j=0;j<=s.length()-l;j++){
                boolean ok=true;
                for(int i=j,k=j+l-1;i<=k;i++,k--){
//                    if(s[i]!=s[k]){   //代码没有问题的
//                        ok=false;
//                        break;
//                    }
                }
                if(ok)return s.substring(j,l);;
            }
        }
        return s;
    }
}





























