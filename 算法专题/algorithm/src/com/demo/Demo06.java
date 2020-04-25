package com.demo;

public class Demo06 {
    public void method(int arr[]){
        if (arr==null){return;}
        int length = arr.length;
        if (length  == 0) return;
        int f[] = new int[length];
        f[0] = 0;
        for (int i = 1; i < length; i++) {
            if (arr[i]>arr[i-1]){
                f[i] = f[i-1]+1;
            }else {
                f[i] = 1;
            }
        }
    }
}
