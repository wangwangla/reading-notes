package com.letcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question21 {
    public static void main(String[] args) {
        int arr[] = {};
        maxProfit(arr);
    }
    public static int maxProfit(int[] prices) {
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
}
