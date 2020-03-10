package com.algorithm.sort.shell;

import com.algorithm.sort.father.SortAbstr;

import java.util.Arrays;

public class ShellSort extends SortAbstr {
    public static void sort(Comparable[] comparable){
        //求出h
        int h = 1;
        while (h<comparable.length/2){
            h = h*2+1;
        }

        while (h >= 1) {
            for (int i = h; i < comparable.length; i++) {
                for (int j = i; j > 0; j -= h) {
                    if (greater(comparable[j], comparable[j - 1])) {
                        exch(comparable, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
            h /=2;
        }
    }

    public static void main(String[] args) {
//        Integer integer[] = {2,4,2,5,3,7,8};
//        sort(integer);
//        System.out.printf("integer arr"+ Arrays.toString(integer));
        int n = 100000;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n-i;
        }
        Long start = System.currentTimeMillis();
        sort(arr);
        System.out.println("end"+(System.currentTimeMillis() - start));
    }
}
