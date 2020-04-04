package com.letcode;

public class Question16 {
    public static void main(String[] args) {
        int h [] = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(h);
    }
    public static int trap(int[] height) {
        int max = Integer.MIN_VALUE;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            if (height[i]>max){
                max = height[i];
            }
        }
        int tatal = 0;
        int start = 0;
        int end = length-1;
        for (int i = 0; i < max; i++) {
            while (start<length){
                if (height[start]<=i){
                    start++;
                }else {
                    break;
                }
            }
            while (end>0){
                if (height[end]<=i){
                    end--;
                }else {
                    break;
                }
            }
            tatal += end-start+1;
        }

        for (int i = 0; i < length; i++) {
            tatal -= height[i];
        }
        return tatal;
    }
}
