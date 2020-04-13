package com.algorithm.sort.bogo;

import com.algorithm.sort.father.SortAlgorithm;
import com.algorithm.sort.util.SortUtils;

import java.util.Random;


/**
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * @see SortAlgorithm
 *
 * 这个算法是在网上看到的，排了一下序，花费了300万次 ，行吧。并且还不一定。
 */
public class BogoSort implements SortAlgorithm {

    private static final Random random = new Random();


    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        //从第一个向后判断，相邻的两个大小，后面的比前面的大，就回去只想下一次随机
        for (int i = 0; i < array.length - 1; i++) {
            if (SortUtils.less(array[i + 1], array[i])) return false;
        }
        return true;
    }

    private static int a = 0;
    // Randomly shuffles the array
    private static <T> void nextPermutation(T[] array) {
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            SortUtils.swap(array, randomIndex, i);
            System.out.println(a+++"==========");
        }
    }

    public <T extends Comparable<T>> T[] sort(T[] array) {

        while (!isSorted(array)) {
            nextPermutation(array);
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        BogoSort bogoSort = new BogoSort();

        // print a sorted array
        SortUtils.print(bogoSort.sort(integers));

        // String Input
//        String[] strings = {"c", "a", "e", "b", "d"};
//
//        SortUtils.print(bogoSort.sort(strings));
    }
}
