package com.hanshunping;

public class SparseArray<T extends Comparable> {
    //将数组转换为稀疏数组（如果是存储，那么就直接存储，不需要转换。）
    public void ArrayToSparseArray(int [][]arr){
//        //遍历数组，找出共需要存储的个数sum
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                if (arr[i][j]!=0){
//                    sum ++ ;
//                }
//            }
//        }
//        //创建数组，用来存储数据，数组的大小为temp[sum+1][3]
//        int temp[][] = new int[sum+1][3];
//        int tempi = 0;
//        temp[0][0] = arr.length;
//        temp[0][1] = arr[0].length;
//        temp[0][2] = sum;
//        //遍历数组，将数据存入temp数组
//        for (int i = 0; i < arr.length; i++) {
//            ++tempi;
//            for (int j = 0; j < arr[0].length; j++) {
//                if (arr[i][j]!=0){
//                    temp[tempi][0] = i;
//                }
//            }
//        }
        int num = totalChar(arr,0);
        //创建数组
        int sparseArr[][] = new int[num+1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = num;
        int iIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]!=0){
                    iIndex ++;
                    sparseArr[iIndex][0] = i;
                    sparseArr[iIndex][1] = j;
                    sparseArr[iIndex][2] = arr[i][j];

                }
            }
        }
    }

    public int totalChar(int arr[][],int t){
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == t){
                    num++;
                }
            }
        }
        return num;
    }

    public void  huifu(int arr[][]){
        int arrTemp[][] = new int[arr[0][0]][arr[0][1]];
        for (int i = 1; i < arr.length; i++) {
            arrTemp[arr[1][0]][arr[1][1]] = arr[1][2];
        }
    }
}
