package com.question.demo;

/**
 * 将奇偶位进行交换
 * - 先得到奇数位，在的大偶数位
 * - 将基数右移
 * - 将偶数位左移
 * - 异或
 *
 * 这个里面有一个就是a和5，可以转化为2进制
 */
public class Question5 {
    public static void main(String[] args) {
        sou1(8);
    }

    public static void sou1(int N){
        int ou = N & 0xaaaaaaaa;
        int ji = N & 0x55555555;
        ji = ji<<1;
        ou = ou>>1;
        System.out.println(ji^ou);
    }
}
