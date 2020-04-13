package com.letcode;

import java.util.ArrayList;

public class Question17 {
    public String longestPalindrome(String str) {
        if (str == null || str.length() == 1 || str.equals("")) {
            return str;
        }
        if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1)) {
                return str;
            }
            return str.charAt(0) + "";
        }
        int step = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String temp = "";
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                step = 2;
                stringBuilder.append(str.charAt(i));
                stringBuilder.insert(0, str.charAt(i - 1));
                while (true) {
                    if (i - step >= 0 && i + step < str.length()) {
                        if (str.charAt(i - step + 1) == str.charAt(i + step)) {
                            stringBuilder.insert(0, str.charAt(i - step + 1));
                            stringBuilder.append(str.charAt(i + step));
                            step++;
                        } else
                            break;

                    } else {
                        break;
                    }
                }
            }
//            temp = stringBuilder.toString();
            temp = stringBuilder.toString().length() > temp.length() ? stringBuilder.toString() : temp;

            stringBuilder.setLength(0);
            if (str.charAt(i - 1) == str.charAt(i + 1)) {
                step = 2;
                stringBuilder.append(str.charAt(i));
                stringBuilder.insert(0, str.charAt(i - 1));
                stringBuilder.append(str.charAt(i + 1));
                while (true) {
                    if (i - step >= 0 && i + step < str.length()) {
                        if (str.charAt(i - step) == str.charAt(i + step)) {
                            stringBuilder.insert(0, str.charAt(i - step));
                            stringBuilder.append(str.charAt(i + step));
                            step++;
                        } else
                            break;
                    } else {
                        break;
                    }
                }
            }
            temp = stringBuilder.toString().length() > temp.length() ? stringBuilder.toString() : temp;
            stringBuilder.setLength(0);
            if (str.charAt(i) == str.charAt(i + 1)) {
                step = 2;
                stringBuilder.append(str.charAt(i));
                stringBuilder.insert(0, str.charAt(i));
                while (true) {
                    if (i - step + 1 >= 0 && i + step < str.length()) {
                        if (str.charAt(i - step + 1) == str.charAt(i + step)) {
                            stringBuilder.insert(0, str.charAt(i - step + 1));
                            stringBuilder.append(str.charAt(i + step));
                            step++;
                        } else break;

                    } else {
                        break;
                    }
                }
            }

            temp = stringBuilder.toString().length() > temp.length() ? stringBuilder.toString() : temp;
            list.add(temp);
            stringBuilder.setLength(0);
        }
        String maxString = null;
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max) {
                maxString = list.get(i);
                max = list.get(i).length();
            }
        }
        if (maxString == null) {
            maxString = str.charAt(0) + "";
        }
        return maxString;
    }

    public String longestPalindrome1(String str) {
        //字符长度知道

        //
        return "";
    }
}