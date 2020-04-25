package com.demo;

public class Demo11 {
    enum type {
        up,down
    }
    private type t;
    public void method(int arr[]){
        int n = arr.length;
        if (n<2){
            return;
        }

        int count = 1;
        if (arr[1]-arr[0]>0){
            t = type.down;
        }else {
            t = type.up;
        }
        for (int i = 2; i < n; i++) {
            if (t == type.up){
                if (arr[i]-arr[i-1]>0){
                    count++;
                    t = type.down;
                }
            }else if (t == type.down){
                if (arr[i]-arr[i-1]>0){
                    count++;
                    t=type.up;
                }
            }

        }
    }
}
