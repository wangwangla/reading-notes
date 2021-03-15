package com.letcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:28188
 * @date: 2021/3/13
 * @time: 16:17
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 修改了三次。
 * a.第一次没注意到开始比当前的还小，那好吧，排序
 * b.当前的末尾比正在比较的大，
 * c.相同的
 */
public class Question35 {
    public static void main(String[] args) {
//        int xx[][] = {{1,4},{4,5}};
        int xx[][] = {{1,3},{2,6},{8,10},{15,18}};
        merge(xx);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null) return intervals;
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int[] interval : intervals) {
            if (start == Integer.MIN_VALUE) {
                start = interval[0];
                end = interval[1];
                continue;
            }
            if (interval[0]<=end){
                if (interval[1]>end) {
                    end = interval[1];
                }
                if (interval[0]<start){
                    start = interval[0];
                }
            }else {
                list.add(new int[]{start,end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start,end});
        return list.toArray(new int[list.size()][2]);
    }
}
