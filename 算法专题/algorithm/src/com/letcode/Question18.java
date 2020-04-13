package com.letcode;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question18 {
    public static void main(String[] args) {

        int arr[] = {
                2,1,4,5,3,1,1,3
        };
        massage(arr);
    }
    public static int massage(int[] nums) {
        int lenth = nums.length;
        int f[] = new int[lenth+1];
        //一个人步约
        f[0] = 0;
        int max = 0;

        f[0] = 0;
        for (int i = 1; i <= lenth; i++) {

            if (i == 1||i==2){
                f[i] = nums[i-1];
            }else {
                f[i] =nums[i-1] + Math.max(f[i-2],f[i-3]);
            }
        }
        return f[lenth]>f[lenth-1]?f[lenth]:f[lenth-1];
    }
}
