package com.algorithm.sort.quicksort;

import com.algorithm.sort.father.SortAbstr;

/**
 * 快速排序
 */
public class QuickSort extends SortAbstr {
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length - 1;
        sort(a,lo,hi);
    }
    public static void sort(Comparable a[],int start,int end){
        int lo = start;
        if (end<=lo){
            return;
        }
        //分组
        int position = partition(a,start,end);
        //左边有序
        sort(a,start,position-1);
        //右边有序
        sort(a,position+1,end);
    }

    public static int partition(Comparable[] a, int start, int end){
        int left = start;
        int right = end+1;
        Comparable key = a[start];
        while(true){
            while((key.compareTo(a[++left]))>0){
                if (left>=end){
                    break;
                }
            }
            while((key.compareTo(a[--right]))>0){
                if (right<=start){
                    break;
                }
            }
            if (left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        //将定义标准的值进行交换
        exch(a,start,left);
        return left;
    }
}
