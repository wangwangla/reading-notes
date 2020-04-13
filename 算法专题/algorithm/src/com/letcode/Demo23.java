package com.letcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo23 {
    private int nums[];
    public Demo23(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList();
        int index = -1;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                n++;
                if (index == -1){
                    index = i;
                    arrayList.get(index);
                }else {
                    arrayList.add(i);
                    index = arrayList.get(random.nextInt(n));
                }

            }
        }
        return index;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(1));
        }

    }
}
