package com.letcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question14 {
    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.5 MB
     * , 在所有 Java 提交中击败了
     * 32.63%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length<1)return -1;
        if (nums[0]>target){
            for (int i = 0; i < nums.length; i++) {
                if (nums[nums.length-1-i] == target){
                    return nums.length-1-i;
                }
                else if (nums[nums.length-1-i]<target){
                    return -1;
                }
            }
        }else if (nums[0]==target){
            return 0;
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==target){
                    return i;
                }
                else if (nums[i]>target){
                    return -1;
                }
            }
        }
        return -1;
    }
}
