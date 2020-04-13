package com.algorithmfuxi.sort;

import com.algorithm.sort.quicksort.QuickSort;

import java.util.Random;

public class Sort {
    public static void main(String[] args) {
//        Random random = new Random(System.currentTimeMillis());
        Comparable[] comparables = new Comparable[9];
//        for (int i=0;i<10;i++){
//            comparables[i]=random.nextInt(100);
//        }
//
        comparables[0] = 6;
        comparables[1] = 1;
        comparables[2] = 2;
        comparables[3] = 7;
        comparables[4] = 9;
        comparables[5] = 3;
        comparables[6] = 4;
        comparables[7] = 5;
        comparables[8] = 8;
        System.out.printf("排序前：");
        for (int i = 0; i < comparables.length; i++) {
            System.out.printf(comparables[i]+"  ");
        }

//        Bubble(comparables);
//        System.out.println();
//        System.out.printf("冒泡排序后：");
//        for (int i = 0; i < comparables.length; i++) {
//            System.out.printf(comparables[i]+"  ");
//        }

//        selecct(comparables);
//        System.out.println();
//        System.out.printf("select排序后：");
//
//
//        insertSort(comparables);
//        System.out.println();
//        System.out.printf("插入排序之后：");

//
//        shell(comparables);
//        System.out.println();
//        System.out.printf("shell排序之后：");


//        shell(comparables);
//        System.out.println();
//        System.out.printf("归并排序之后：");
       // QuickSort.sort(comparables);
        quickSort(comparables);
        System.out.println();
        System.out.printf("q=kuai排序之后：");


        for (int i = 0; i < comparables.length; i++) {
            System.out.printf(comparables[i]+"  ");
        }
    }

    /**
     * 冒泡排序
     * @param comparable
     */
    public static void Bubble(Comparable []comparable){
        for (int i = 0; i < comparable.length-1; i++) {
            for (int j = 0; j < comparable.length-i-1; j++) {
                if (greater(comparable,j,j+1)){
                    exch(comparable,j,j+1);
                }
            }
        }
    }

    /**
     * 选择排序
     * @param comparables
     */
    public static void selecct(Comparable[] comparables){
        int min ;
        for (int i = 0; i < comparables.length-1; i++) {
            min = i;
            for (int j = i; j < comparables.length; j++) {
                if (greater(comparables,min,j)){
                    min = j;
                }
            }
            if (min != i){
                exch(comparables,min,i);
            }
        }
    }

    /**
     * 插入排序
     * @param comparable
     */
    public static void insertSort(Comparable[] comparable){
        for (int i = 1; i < comparable.length; i++) {
            for (int j = i; j >=1; j--) {
                if (greater(comparable,j,j-1)){
                    exch(comparable,j,j-1);
                }
            }
        }
    }

    public static void shell(Comparable[] comparables) {
        //计算h
        int h = 1;
        while (h<comparables.length/2){
            h = 2*h+1;
        }

        while (h>=1){
            for (int i=h;i<comparables.length;i++){
                for (int j = i; j >=h ; j=j-h) {
                    if (greater(comparables,j,j-h)){
                        exch(comparables,j,j-h);
                    }
                }
            }
            h = h/2;
        }
    }

    public static void guibing(Comparable[]comparables){
        //归并，将所有的数据分为两部分，一直分，使用一个辅助数组，拍完序的复制回原来的地方
        comparaTemp = new Comparable[comparables.length];
        int start = 0;
        int end = comparables.length;
        sort(comparables,start,end-1);

    }

    //
    private static Comparable[] comparaTemp;

    private static void sort(Comparable[]comparables,int start,int end){
        if (start>=end){return;}
        int mid = (start+end)/2;
        sort(comparables,start,mid);
        sort(comparables,mid+1,end);
        marge(comparables,start,mid,end);
    }

    private static void marge(Comparable[] comparables, int start,int mid, int end) {
        //需要一个辅助数组
        int tempIndex = start;
        int p1 = start;
        int p2 = mid+1;
        while (p1<=mid&&p2<=end){
            if (greater(comparables,p1,p2)){
                //p1大
                comparaTemp[tempIndex++] = comparables[p1++];
            }else {
                comparaTemp[tempIndex] = comparables[p2++];
            }
        }
        while (p1<=mid){
            comparaTemp[tempIndex] = comparables[p1++];
        }
        while (p2<=mid){
            comparaTemp[tempIndex] = comparables[p2++];
        }

        for (int i = start; i < end; i++) {
            comparables[i] = comparaTemp[i];
        }
    }

    public static void quickSort(Comparable[]comparables){
        //找一个值，小的放左边，大的放右边
        int start = 0;
        int end = comparables.length-1;
        quickSort(comparables,start,end);
    }
    public static void quickSort(Comparable[]comparables,int start,int end){
        //找一个值，小的放左边，大的放右边
        int left = start;
        int right = end;
        if (right<=left){
            return;
        }

        int position = partition(comparables,left,right);
        quickSort(comparables,start,position-1);
        quickSort(comparables,position+1,end);
    }

    private static int partition(Comparable[] comparables, int left, int right) {
        int leftIndex = left;
        int rightIndex = right+1;

        while (true){
            while (less(comparables,++leftIndex,left)){
                if (leftIndex==right){
                    break;
                }
            }
            while (less(comparables,left,--rightIndex)){
                if (rightIndex==left){
                    break;
                }
            }
            if (leftIndex>=rightIndex){
                break;
            }else {
                exch(comparables,leftIndex,rightIndex);
            }
        }
        exch(comparables,left,leftIndex);
        return leftIndex;
    }




    public static boolean greater(Comparable[] comparaArr,int i,int j){
        return comparaArr[i].compareTo(comparaArr[j])>0;
    }

    public static boolean less(Comparable[] comparaArr,int i,int j){
        return comparaArr[i].compareTo(comparaArr[j])<0;
    }


    public static void exch(Comparable[]comparaArr,int i,int j){
        Comparable comparaTemo = comparaArr[i];
        comparaArr[i] = comparaArr[j];
        comparaArr[j]=comparaTemo;
    }

}


