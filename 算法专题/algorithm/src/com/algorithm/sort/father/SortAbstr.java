package com.algorithm.sort.father;

public class SortAbstr {
    /**
     * 比较大的数据
     * @param v
     * @param w
     * @return
     */
    protected static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     * 数据元素进行交换
     * @param a
     * @param i
     * @param j
     */
    protected static void exch(Comparable[] a, int i, int j){
        Comparable temp ;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
