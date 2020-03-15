package com.algorithm.sort.guibing;

import com.algorithm.sort.father.SortAbstr;

import java.util.Arrays;

/**
 * 归并排序
 */
public class GuiBingSort extends SortAbstr {
    public void sort(int a[]){
        arr = new int[a.length];
        int start = 0;
        int end = a.length-1;
        sort(a,start,end);
    }

    public void sort(int a[],int start,int end){
        if (start>=end){
            return;
        }
        //分
        int mid = (start + end)/2;
        sort(a,start,mid);
        sort(a,mid+1,end);
        merge(a,start,mid,end);

    }
    private int arr[];
    public void merge(int a[],int start,int mid,int end){
        int assIndex = start;
        int p1 = start;
        int p2 = mid+1;
        while (p1<=mid&&p2<=end){
            if (a[p1]>a[p2]){
                arr[assIndex++] = a[p1++];
            }else {
                arr[assIndex++] = a[p2++];
            }
        }
        while (p1<=mid){
            arr[assIndex++] = a[p1++];
        }
        while (p2<=end){
            arr[assIndex++] = a[p2++];
        }
        for (int i = start; i <= end; i++) {
            a[i] = arr[i];
        }
    }

    public static void main(String[] args) {
        GuiBingSort guiBingSort = new GuiBingSort();
        int [] arr={2,4,7,3,1};
        guiBingSort.sort(arr);
        System.out.printf("数组："+ Arrays.toString(arr));
    }
}
