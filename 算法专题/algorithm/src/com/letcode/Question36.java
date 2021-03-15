package com.letcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:28188
 * @date: 2021/3/13
 * @time: 16:52
 *
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Question36 {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        int start = 0;
        for (int[] interval : intervals) {
            if (interval[1]>newInterval[0]){
                if (interval[1]>newInterval[1]){
                    //也在
                }else {
                    continue;
                }
            }

        }
        return null;
    }
}
