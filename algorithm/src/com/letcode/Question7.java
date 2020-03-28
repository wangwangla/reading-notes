package com.letcode;

import java.util.ArrayList;

/***
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *
 * 98 / 103 难受呀
 */
public class Question7 {
    public static String method(String str){

        if (str==null||str.length()==1||str.equals("")) {
            return str;
        }
        if (str.length()==2){
            if (str.charAt(0) == str.charAt(1)){
                return str;
            }
            return str.charAt(0)+"";
        }
        int step = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String temp = "";
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i)==str.charAt(i-1)){
                step = 2;
                stringBuilder.append(str.charAt(i));
                stringBuilder.insert(0,str.charAt(i-1));
                while (true){
                    if (i-step>=0&&i+step<str.length()){
                        if(str.charAt(i-step+1)==str.charAt(i+step)){
                            stringBuilder.insert(0,str.charAt(i-step+1));
                            stringBuilder.append(str.charAt(i+step));
                            step++;
                        }else
                            break;

                    }else{
                        break;
                    }
                }
            }
//            temp = stringBuilder.toString();
            temp = stringBuilder.toString().length()>temp.length()?stringBuilder.toString():temp;

            stringBuilder.setLength(0);
            if (str.charAt(i-1)==str.charAt(i+1)){
                step = 2;
                stringBuilder.append(str.charAt(i));
                stringBuilder.insert(0,str.charAt(i-1));
                stringBuilder.append(str.charAt(i+1));
                while (true){
                    if (i-step>=0&&i+step<str.length()){
                        if(str.charAt(i-step)==str.charAt(i+step)){
                            stringBuilder.insert(0,str.charAt(i-step));
                            stringBuilder.append(str.charAt(i+step));
                            step++;
                        }else
                            break;
                    }else{
                        break;
                    }
                }
            }
            temp = stringBuilder.toString().length()>temp.length()?stringBuilder.toString():temp;
            stringBuilder.setLength(0);
            if (str.charAt(i)==str.charAt(i+1)){
                step = 2;
                stringBuilder.append(str.charAt(i));
                stringBuilder.insert(0,str.charAt(i));
                while (true){
                    if (i-step+1>=0&&i+step<str.length()){
                        if(str.charAt(i-step+1)==str.charAt(i+step)){
                            stringBuilder.insert(0,str.charAt(i-step+1));
                            stringBuilder.append(str.charAt(i+step));
                            step++;
                        }else break;

                    }else{
                        break;
                    }
                }
            }

            temp = stringBuilder.toString().length()>temp.length()?stringBuilder.toString():temp;
            list.add(temp);
            stringBuilder.setLength(0);
        }
        String maxString=null;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length()>max){
                maxString = list.get(i);
                max = list.get(i).length();
            }
        }
        if (maxString==null){
            maxString = str.charAt(0)+"";
        }
        return maxString;
    }
    public static void main(String[] args) {
//        String str = "abcdedcba";
//        String str = "abb";
//        System.out.println(str.length());
//        System.out.println(method(str));

        String str = "babad";
        str = "";
        str = "aaaa";
        str = "babad";
        str = "babadada";
        str = "cillisyoskdodzlpbltefiz";
        System.out.println(method(str));

    }
}
