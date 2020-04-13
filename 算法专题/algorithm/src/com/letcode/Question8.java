package com.letcode;

/**
 * 整数转换
 *
 * 这种方式有个问题，string怎样转换回来,可以使用Long，但是letcode是并不可以，无法实现 方法
 */
public class Question8 {
    public static int mathod(int x){
        if (x == 0){
            return 0;
        }
        StringBuilder string = new StringBuilder();
        if (x < 0){
            string.append("-");
        }
        x=Math.abs(x);
        while(x>0){
            string.append(x%10);
            x = x/10;
        }
        if(Long.parseLong(string.toString())>Integer.MAX_VALUE||Long.parseLong(string.toString())<Integer.MIN_VALUE) {
            return 0;
        }
        return Integer.parseInt(string.toString());
    }

    public static int mathod2(int x){
        int temp = x;
        if (x == 0){
            return 0;
        }
        x=Math.abs(x);
        int num = 0;
        int i = 0;
        while(x>0){
            //需要注意这个判断的放置位置
            if(num>Integer.MAX_VALUE/10||num<Integer.MIN_VALUE/10) {
                return 0;
            }
            num = (x%10)+num*10;
            i++;
            x = x/10;
        }
        return temp>0?num:-num;
    }

    public static int reverse(int x) {
        if(x>Integer.MAX_VALUE||x<Integer.MIN_VALUE) {
            return 0;
        }
        int temp=0;
        int mod;
        boolean flag=false;
        if(x<0) {
            x = -x;
            flag = true;
        }
        while(x>0) {
            mod = x%10;
            if(temp > Integer.MAX_VALUE/10||temp<Integer.MIN_VALUE/10){
                return 0;
            }
            temp = temp*10+mod;
            x = x/10;
        }
        if(flag) {
            return -temp;
        }else {
            return temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
        System.out.println(mathod2(-2147483412));
//        String str = "9646324351";
//        System.out.println(Long.parseLong(str));
    }
}
