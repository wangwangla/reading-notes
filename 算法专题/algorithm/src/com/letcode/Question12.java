package com.letcode;

/**
 *
 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。
 */
public class Question12 {
    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 80.41%
     * 的用户
     * 内存消耗 :
     * 37.4 MB
     * , 在所有 Java 提交中击败了
     * 55.61%
     * 的用户
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        if (strs.length ==1){
            return strs[0];
        }
        int index = 0;
        boolean flag=true;
        int min = Integer.MAX_VALUE;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            min = min > strs[i].length()?strs[i].length():min;
        }
        while (true){
            if(index > min-1){
                break;
            }
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (c != strs[i].charAt(index)){
                      flag =  true;
                      break;
                }else {
                    flag = false;
                }
            }
            if (!flag){
                builder.append(c);
            }else {
                break;
            }
            index++;

        }
        return builder.toString();
    }

    public static void main(String[] args) {
//        String[]arr = {"dog","racecar","car"};
        String[]arr ={"aca","cba"};

        System.out.println(longestCommonPrefix(arr));
    }
}
