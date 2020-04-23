package com.algorithm.sort.select;

import com.algorithm.sort.father.SortAbstr;

/**
 * 选择排序
 * 1.选择第一个值，一次向后，每次找出一个最值，将最值与第一个值交换
 */
public class SelectSort extends SortAbstr {
    public static void sort(Comparable[] a){
        int min = Integer.MIN_VALUE;
        //最后一个数据了，就不需要在比较了，所以是length-1
        for (int i = 0; i < a.length-1; i++) {
            min = i;
            //第一次从1开始，下来是2……
            for (int j = 1+i; j < a.length; j++) {
                if (greater(a[min],a[j])){
                    min = j;
                }
            }
            //如果数据没有变化，就不要浪费资源了
            if (min !=i){
                exch(a,i,min);
            }
        }
    }
}
