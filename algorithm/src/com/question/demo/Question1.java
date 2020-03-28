package com.question.demo;

/**
 * 1-10是个数字，放在11个大小的数组中，然后有一个重复，那么重复的异或之后为0.
 * 解题：
 * 如果是直接的疑惑，相同的为0，为了可以不为0，那么自己进行凑成2个，所以相同的就是三个
 * 最后在进行异或，就可以得到值。
 *
 * 这个的这种解法扩展成任意数据，这个方法，就不行了
 */
public class Question1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,7,7,8,9,10,6,11};
        sou1(arr);
        sou2(arr);
    }

    public static void sou1(int arr[]){

        int x1 = 0;
        for (int i = 1; i < arr.length; i++) {
            x1 = x1^i;
        }
        System.out.println("==="+x1);

        for (int temp = 0; temp < arr.length; temp++) {
            x1 = x1^arr[temp];
        }
        System.out.println(""+x1);
    }

    public static void sou2(int arr[]){
        int temp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]==2){
                System.out.println(i+"");
            }
        }
    }

}
