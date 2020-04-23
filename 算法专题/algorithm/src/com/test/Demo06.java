package com.test;

public class Demo06 {
    private static int a = 0,b = 0;
    private static int i = 0,j =0;
    public static void main(String[] args) throws Exception{
       Thread t1 = new Thread(()->{
           a = 1;
           i = b;
       });
        Thread t2 = new Thread(()->{
            b = 1;
            j = a;
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

/**
 *
 * t1执行   a == 1;  b -> i   i =0 ;
 *         a == 1, b -> 1   j=1；
 * t2执行
 */