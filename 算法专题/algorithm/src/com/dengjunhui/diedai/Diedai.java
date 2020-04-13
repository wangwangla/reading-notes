package com.dengjunhui.diedai;

/**
 * 迭代
 *
 * 时间复杂度O(n)
 *
 * 空间复杂度：
 * 方式一：输入+输出+变量
 * 方式二：输出+变量    （sum + i）  一般采用的是这个方式
 *
 * 这个也就是一个减而知之，也可以使用递归的返回时来进行解决。
 */
public class Diedai {
    int SumI(int A[],int n){
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=A[i];
        }
        return sum;
    }

    /**
     * 所需要的时间为o(1)*(n+1)
     * @param A
     * @param n
     * @return
     */
    public int sum(int A[],int n){
        if (n<1){
            return 0;
        }
        return sum(A,n-1)+A[n-1];
    }
}
