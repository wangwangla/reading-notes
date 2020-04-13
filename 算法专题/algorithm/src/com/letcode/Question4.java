package com.letcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 我的思路：
 * 方法一：
 *  那就先排序，然后在找出  因为数组本来就是有序的，和归并排序的matge一样
 *  创建一个新数组，将数据都复制进去。
 *  奇数就取出最中间的一个
 *  偶数就取出中间的两个
 *
 * 优化：
 *   奇数和偶数都是找出中间的，所以根据两个数组，只需要创建出一般的数组就可以了，排序也可以进行减半
 *
 *
 *
 * 在优化：
 *   不需要创建数组，两个变量 left right,
 *   - 先判断是奇数  偶数
 *
 *
 * 官方解法：
 *  明确一下，最终想要的结果：
 *  左边最大等于小于右边的最小，
 *
 *      public double findMedianSortedArrays(int[] A, int[] B) {
 *         int m = A.length;
 *         int n = B.length;
 *         if (m > n) { // to ensure m<=n
 *             int[] temp = A; A = B; B = temp;
 *             int tmp = m; m = n; n = tmp;
 *         }
 *         int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
 *         while (iMin <= iMax) {
 *             int i = (iMin + iMax) / 2;
 *             int j = halfLen - i;
 *             if (i < iMax && B[j - 1] > A[i]) {
 *                 iMin = i + 1; // i is too small
 *             } else if (i > iMin && A[i - 1] > B[j]) {
 *                 iMax = i - 1; // i is too big
 *             } else { // i is perfect
 *                 int maxLeft;
 *                 if (i == 0) {//A分成的leftA(空集) 和 rightA(A的全部)  所以leftPart = leftA(空集) + leftB,故maxLeft = B[j-1]。
 *                     maxLeft = B[j - 1];
 *                 } else if (j == 0) { //B分成的leftB(空集) 和 rightB(B的全部)  所以leftPart = leftA + leftB(空集),故maxLeft = A[i-1]。
 *                     maxLeft = A[i - 1];
 *                 } else { //排除上述两种特殊情况，正常比较
 *                     maxLeft = Math.max(A[i - 1], B[j - 1]);
 *                 }
 *                 if ((m + n) % 2 == 1) { //奇数，中位数正好是maxLeft
 *                     return maxLeft;
 *                 }
 *                 //偶数
 *                 int minRight;
 *                 if (i == m) {//A分成的leftA(A的全部) 和 rightA(空集)  所以rightPart = rightA(空集) + rightB,故minRight = B[j]。
 *                     minRight = B[j];
 *                 } else if (j == n) {//B分成的leftB(B的全部) 和 rightB(空集)  所以rightPart = rightA + rightB(空集),故minRight = A[i]。
 *                     minRight = A[i];
 *                 } else {//排除上述两种特殊情况，正常比较
 *                     minRight = Math.min(B[j], A[i]);
 *                 }
 *
 *                 return (maxLeft + minRight) / 2.0;
 *             }
 *         }
 *         return 0.0;
 *     }
 */
public class Question4 {

}
