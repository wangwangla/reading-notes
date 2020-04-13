package com.dengjunhui.digui;

/**
 * 递归将数组的值进行倒置
 */
public class Digui {
    public static void main(String[] args) {

    }

    public void reserse(int arr[],int lo,int hi){
        if (lo<hi){
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            reserse(arr,lo+1,hi+1);
        }
    }

    /**
     * 数组的和
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    public int binaSum(int arr[],int lo,int hi){
        if (lo == hi)return arr[lo];
        int mid = (lo + hi)>>1;
        return binaSum(arr,lo,mid)+binaSum(arr,mid+1,hi);
    }

    public void findMaxAndMin(int arr[],int lo ,int hi){
        //找出最大的和最小的 ，  比较次数尽可能的少
    }

    int fbnq(int n){
        if (n<2){
            return n;
        }else {
            return fbnq(n-1)+fbnq(n-2);
        }
    }

    int fbnq1(int n){
        return n<2?n:fbnq1(n-1)+fbnq1(n-2);
    }


}
