package com.algorithm.dongtaiguihua;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Question2 {
    /**
     * 偷东西 不能偷相邻的
     */
    public static int rob(int[] nums) {
        if (nums.length==0)return 0;

        int f[] = new int[nums.length+1];
        f[0] = 0;
        f[1] = nums[0];
        f[2] = nums[1];
        for (int i = 3; i < f.length; i++) {
            f[i] = nums[i-1] + Math.max(f[i-3],f[i-2]);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max)
                max = nums[i];
        }
        return max;
    }

    public int method2(int [] A){
        int n = A.length;
        if (n == 0){
            return 0;
        }
        int [] f = new int[n+1];
        f[0] = 0;
        f[1] = A[0];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i-1],f[i-1]+A[i-1]);
        }
        return 0;
    }

    /**
     * 买股票，那一天卖出获得的利润最大
     */
    public int maxLiRun1(int prices[]){
        if (prices.length==0){
            return 0;
        }
        int length = prices.length;
        int f[] = new int[length];
        f[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            f[i] = 0;//卖入   买出
            f[i] = Math.max(f[i-1],prices[i]-min);
            if (min >prices[i]){
                min = prices[i];
            }
        }
        return f[length-1];
    }
    /**
     * 可以有多天进行买卖
     */
    public void maxLiRun(int arr[]){
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i-1]){
                max += arr[i-1] - arr[i];
            }
        }
    }

    /**
     * 只可以有两次买卖
     */
    public int maxLiRun3(int arr[]){
        return 0;
    }

    /**
     * 最长序列  从小到大 ，不是连续的
     * @param A
     * @return
     */
    public static int maxLongXulie(int []A){
        int n = A.length;
        int f[] = new int[n];
        int max = 0;
        for (int j = 0; j < n; j++) {
            f[j] = 1;
            for (int i = 0; i<j ; i++) {
                if (A[i]<A[j]&&f[i]+1>f[j]){
                    f[j]= f[i]+1;
                }
            }
            max = Math.max(max,f[j]);
        }
        return 0;
    }

    public void maxCeng(int arr[][]){
        //先排序 ，排一列
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
//        [[1,2],[3,4]]  排序方式，先排序长  如果长符合条件  在接着比较宽    如果长不符合，那么就返回小
        int n = arr.length;
        int f[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][0]<arr[i][0]&&arr[j][1]<arr[j][1]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            max = Math.max(f[i],max);
        }
    }

    public static void main(String[] args) throws IOException {
        int arr[] = {
                1,4,6,3,4,8
        };
        maxLongXulie(arr);
    }
}
