package com.letcode;

/**
 * @author:28188
 * @date: 2021/3/11
 * @time: 22:18
 */
public class Question33 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < len/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][i];
                matrix[len-i-1][j] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = matrix[j][len-i-1];
                matrix[j][len-i-1] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


//        int len = matrix.length;
//        for (int i = 0; i < len / 2; i++) {
//            int start = i;
//            int end = len - i - 1;
//            for (int j = 0; j < end - start; j++) {
//                int temp = matrix[start][start + j];
//                matrix[start][start + j] = matrix[end - j][start];
//                matrix[end - j][start] = matrix[end][end - j];
//                matrix[end][end - j] = matrix[start + j][end];
//                matrix[start + j][end] = temp;
//            }
//        }
    }

    public static void main(String[] args) {
        int [][] mar = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate1(mar);
    }

    public static void rotate2(int[][] matrix) {
        int length = matrix.length;
        int arr[][]= new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
//                arr[][] = matrix[i][j];
            }
        }
    }

        public static void rotate1(int[][] matrix) {
        int len = matrix.length;
        int arr [][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[j][len - 1- i] = matrix[i][j];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        // 先来一次

//        for (int i = 0; i < len/2; i++) {
//            for (int j = 0; j < len/2; j++) {
//                int rr = arr[j][i];
//                arr[j][i] = arr[i][j];
//                arr[i][j] = rr;
//            }
//        }
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                System.out.print(arr[i][len-j-1]);
//            }
//            System.out.println();
//        }
    }
}
