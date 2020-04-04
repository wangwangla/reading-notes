package com.letcode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question19 {
    public static void main(String[] args) {
        int arr[] ={-2,1,-3,4,-1,2,1,-5,4};
        //0  1  -2  1/4  3  2/5  1/6  1/-5    5/4
        maxSubArray(arr);
    }
    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int  f[] = new int[length];
        f[0] = nums[0];
        for (int i = 1; i < f.length; i++) {
            f[i] = Math.max(nums[i],f[i-1]+nums[i]);
        }
        int  max = Integer.MIN_VALUE;
        for (int i = 0; i < f.length; i++) {
            if (f[length]>max){
                max = f[length];
            }
        }
        return f[length];
    }
}
