package com.algorithm.sort.bubble;

import com.algorithm.sort.father.SortAbstr;

/**
 * 冒泡排序
 * 1.冒泡排序的最大趟数为i = a.length-1
 * 2.每趟比较的次数为i
 *
 * 比较的结构是最后一个值为最值
 *
 */
public class Bubble extends SortAbstr {
    /**
     * 对数组进行排序
     * @param a
     */
    public static<T extends Comparable<T>> void sort(T[] a){
        //冒泡次数
        for (int i = a.length - 1; i > 0 ; i--) {
            //冒泡最大的索引
            for (int j = 0; j < i; j++) {
                //比较索引和索引j+1
                if (greater(a[j],a[j+1])){
                    exch(a,i,j);
                }
            }
        }
    }
}
