package com.letcode;

import java.util.*;
public class Demo {
    public List<Integer> minSubsequence(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
        }
        int temp = 0;
        int mub = max/2;
        int f[] = new int[nums.length+1];
        f[0] = 0;
        //我们的目标是 max/2
        for (int i = 1; i <= nums.length; i++) {
//            temp+=nums[i];
//            if (temp>mub){
//
//            }
            f[i] = f[i-1] + nums[i-1];
            if (f[i]>mub){
                System.out.println(f[i]);
            }
        }
        return null;
    }

    public static List<Integer> minSubsequence1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
        }
        int temp = 0;
        int mub = max/2;
        int f[][] = new int[nums.length+1][2];
        f[0][0] = 0;
        f[0][0] = 0;
        //我们的目标是 max/2
        for (int i = 1; i <= nums.length; i++) {
            f[i][0] = f[i-1][0] + nums[i-1];
            f[i][1] = f[i-1][1]+1;

            if (f[i][0]>mub&&f[i][1]>1){
                int te = f[i][0] - f[i-f[i][1]][0];
                f[i][0] -=1;
                System.out.println(f[i][0]);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int arr[] ={4,3,10,9,8};
        minSubsequence1(arr);
    }

}
