package com.test;

import java.util.Arrays;
import java.util.Random;

/**
 * 支持更多数据类型
 */
public class Youhua {
    public static void main(String[] args) {
        int  arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
//        System.out.printf("原始数组：");
//        printArr(arr);
//        swap(arr,2,3);
//        printArr(arr);
//        Random random = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            int z = random.nextInt(100);
//            //    System.out.print(z);
//            arr[i] = z;
//        }
//        System.out.printf("原始数组：");
//        printArr(arr);
////        souf
//        System.out.printf("插入排序：");
//        sort(arr,0,arr.length);
//        printArr(arr);
//        System.out.printf("选择排序：");
//        selectSort(arr,0,arr.length);
//        printArr(arr);
//        System.out.printf("冒泡数组：");
//        maopao(arr,0,arr.length);
//        printArr(arr);
//
//        System.out.printf("shell数组：");
//        shellSort(arr,0,arr.length);
//        System.out.printf("=============");
//        printArr(arr);
    }

    static void swap(int arr[],int x,int y){
        int z = arr[x] ;
        arr[x] = arr[y];
        arr[y] = z;
    }
//
//    public static void printArr(int arr[]){
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+"   ");
//        }
//        System.out.println();
//    }
//
//    public static void sort(int arr[],int start,int end){
//        for (int i = 1+start; i < end; i++) {
//            for (int j = i;j>start;j--){
//                if(arr[j-1]>arr[j]){
//                    swap(arr,j-1,j);
//                }
//            }
//        }
//    }
//
//    public static void selectSort(int arr[],int l ,int r){
//        int i,j;
//        for (int k = l; k < r; k++) {
//            int min = k;
//            for(j = k + 1;j< r;j++){
//                if(arr[min]>arr[j]){
//                    min = j;
//                }
//            }
//            if(min != k){
//                swap(arr,min,k);
//            }
//        }
//        printArr(arr);
//    }
//
//    public static void maopao(int arr[],int i,int j){
//        for (int k = 0; k < j-1; k++) {
//            for (int l = 0; l < j-i-1; l++) {
//                if(arr[l]>arr[l+1]){
//                    swap(arr,l,l+1);
//                }
//            }
//        }
//    }
//
//    /**
//     * 14   61   25   20   65   12   18   7   84   98
//     * 1.先分为好几份
//     * 14   61   25   20 |  65   12   18   7 |  84   98
//     * 2.我们三个一分得到上面的
//     * @param arr
//     * @param l
//     * @param r
//     */
//    public static void shellSort(int arr[],int l,int r){
//        int i,h;
//        for(h = l;h<= (r-1)/9;h = 3*h+1);
//        for(;h>0;h/=3){
//            for (int k = l+h; k < r; k++) {
//                int j = k;
//                int v = arr[k];
//                while(j>=l+h&&(v > arr[j - h])){
////                    if (v > arr[j - h]){
//                    arr[j] = arr[j-h];
//                    j-=h;
////                    }else {
//
////                    }
//                }
//                arr[j] = v;
//            }
//        }
//    }
}
