package com.letcode;

/**
 * @author:28188
 * @date: 2021/3/13
 * @time: 17:01
 */
public class Question37 {
    public static void main(String[] args) {
        String x = "a";
        System.out.println(lengthOfLastWord(x));
    }

    public static int lengthOfLastWord1(String s) {
        if (s==null)return 0;
        String[] s1 = s.split(" ");
        if (s1.length == 0)return 0;
        int ii = s1.length-1;
        while (s1[ii].trim() == ""){
            ii--;
            if (ii<0){
                return 0;
            }
        }
        return s1[ii].length();
    }
    public static int lengthOfLastWord(String s) {
            if (s==null)return 0;
            int ll = 0;
            for (int i =s.length()-1;i>=0; i--) {
                char c = s.charAt(i);
                if (c>='a'&&c<='z' || c>'A'&&c<'Z') {
                    ll ++;
                }else if (ll>0){
                    return ll;
                }
            }
            return ll;
        }
}
