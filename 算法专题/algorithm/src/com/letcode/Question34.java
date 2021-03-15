package com.letcode;

/**
 * @author:28188
 * @date: 2021/3/11
 * @time: 23:00
 */
public class Question34 {
    public static
    double myPow(double x, int n) {
        int num = n/2;
        if (num < 0)num =-num;
        double res = 1;
        if(n == 0) return 1;
        if (x==1)return 1;
        if (x == -1){
            if(n%2 == 0){
                return 1;
            }else {
                return -1;
            }
        }
        while (num>0){
            num--;
            res *= x;
        }
        res = res * res;
        if(n % 2 != 0){
            res =  res * x;
        }
        if(n<0){
            res = 1/res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(1.00000 ,-2147483648));
    }

}
