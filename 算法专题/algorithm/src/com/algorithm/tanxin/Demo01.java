package com.algorithm.tanxin;

import java.util.Arrays;

public class Demo01 {
    public void method(int tang[],int children[]){
        Arrays.sort(tang);
        Arrays.sort(children);
        int t = 0;
        int c = 0;
        while (t<tang.length||c<children.length){
            if (tang[t]>=children[c]){
                t++;
                c++;
            }else {
                t++;
            }
        }
    }
}
