package com.algorithm.sort.bubble;

import com.algorithm.sort.father.SortAbstr;

public class Bubble extends SortAbstr {
    /**
     * 对数组进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
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
