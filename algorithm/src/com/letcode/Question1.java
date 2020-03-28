package com.letcode;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question1 {

    /**
     * 执行用时 :6 ms
     * , 在所有 Java 提交中击败了54.93%
     * 的用户内存消耗 :41.9 MB, 在所有 Java 提交中击败了5.07%的用户
     * @param nums
     * @param target
     * @return
     */
    private static int[] soution1(int nums[],int target){
        int [] arr = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = target - nums[i];
            if (map.containsKey(temp)){
                arr[0] = i;
                arr[1] = map.get(temp);
            }
            map.put(nums[i],i);
        }
        return arr;
    }

    public int[] twoSum2(int[] nums, int target) {
        int [] arr = new int[2];
        Map<Integer,Integer> m = new HashMap<>();
        int data;
        //先将所有的数据装入一个数组中
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i], i);
        }
        //循环遍历他们
        for(int i=0;i<nums.length;i++) {
            data = target-nums[i];
            if(m.containsKey(data)&&m.get(data) != i) {
                arr[0]=i;
                arr[1]=m.get(data);
                return arr;
            }
        }
        return arr;
    }

    public int[] twoSum(int[] nums, int target) {
        int [] arr = new int[2];
        int data;
        for(int i=0;i<nums.length;i++) {
            data = target-nums[i];
            for(int j=0;j<i;j++) {
                if(data == nums[j]) {
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int []nums = {2, 7, 11, 15};
        int target = 9;
        int arr[] = soution1(nums,target);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

