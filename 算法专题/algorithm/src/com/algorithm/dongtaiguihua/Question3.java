package com.algorithm.dongtaiguihua;

import java.util.Arrays;

public class Question3 {
    /**
     * 给一个正整数，  最少可以将它分为几个完全平方数之和
     *
     * 输入n=13
     * 输出2（13 = 4 + 9）
     *
     * 分析：
     *  - j^2最后一个
     *  - 倒数第二个 n - j^2
     *
     *  转移方程
     *  f[i] = min{f[i-j^2]+1}
     *
     *  初始f[0] = 0;
     *
     *  1~n  i   n^3/2
     *
     *
     */
    public static int mathodOne(int n){
        int f[] = new int[n+1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                if (f[i-j*j]+1<f[i]){
                    f[i] = f[i-j*j]+1;
                    System.out.println(f[i]+"--"+i);
                }
            }
        }
        return f[n];
    }

    /**
     * 给一个字符串s[0,N-1]
     * 要求将字符串划分为若干段，没一段都是一个回文串
     * 求：最少划分几次
     *
     * 比如：
     * aab   划分为aa   b
     */
    public static int method2(String ss){
        char [] s = ss.toCharArray();
        int n = s.length;
        if (n == 0){
            return 0;
        }
        boolean [][] isPalin = new boolean[n][n];
        int i,j;
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = 0; i2 < n; i2++) {
                isPalin[i1][i2] = false;
            }
        }
        for (int t = 0; t < n; t++) {
            //奇数
            i = j = t;
            while (i >= 0&& j<n && s[i] == s[j]){
                isPalin[i][j] = true;
                --i;
                ++j;
            }

            i = j = t;
            j = t+1;
            while (i>=0&&j<n&&s[i] == s[j]){
                isPalin[i][j] = true;
                --i;
                ++j;
            }
        }

        for (int i1 = 0; i1 < n; i1++) {
            System.out.print(s[i1]+"    ");
        }
        System.out.println();
        for (int i1 = 0; i1 < n; i1++) {System.out.printf(s[i1]+"");
            for (int i2 = 0; i2 < n; i2++) {
                System.out.print(isPalin[i1][i2]+"  ");
            }
            System.out.println();
        }

        int f[] = new int[n+1];
        f[0] = 0;
        for (int i1 = 1; i1 <= n; i1++) {
            for (int i2 = 0; i2 <= i1; i2++) {
                if (f[i2]+1<f[i1]&&isPalin[i1][i2] == true){
                    f[i1] = f[i2]+1;
                }
            }
        }
        return 0;
    }

    /**
     * 有N本需要抄写，第i本书A[i]页
     * K个抄写员  可以抄写连续的书
     * 每个抄写元速度一样
     * 最少需要多久可以抄写完
     *
     *
     * 举例
     * A=[324] k= 2
     * 输出：
     * 5 第一个抄写1，2，第二个抄写第3、、
     *
     *
     * 分析：如果只有一个 A[0]+……+A[i]
     * 取决于耗时最长的抄写员
     *
     * 确定状态：
     *      最后一步:最后一个是抄写的部分是连续的书，包含最后一本
     *      如果抄写到N-1本书
     *
     *
     *      k-1个人，是j本书
     *
     * 子问题
     *      k个人最短需要多少时间抄完N本书
     *      k-1个人需要多少时间抄完前J本书
     *
     *      f[k][i]为k个抄写员最少需要多少时间抄完前i笨数
     *
     * 转移方程
     *      第k个抄写员最少需要多少时间抄写完前i本书  = k-1个抄写员最少需要多少时间抄写玩前j本书/第k个抄写员抄写j到i-1本书的时间
     *
     *
     * 初始化条件和边界条件
     *      f[k][i]为k个抄写员最少需要多少时间抄完前i本书
     *      f[k][i] =
     *
     *
     *      初始条件：
     *       - 0个抄写元只能抄写0本
     *       f[0][0] = 0  f[0][i]=正无穷
     *       - k个抄写员需要0时间抄写0本书
     *       f[k][0] = 0
     *
     */
    public static int method03(int  arr[],int K){
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        if(K>n){
            return K;
        }
        int [][]f = new int[+1][n+1];
        int i,j,k;
        //0本书  0个人啥也不需要干
        f[0][0] = 0;
        for (int i1 = 0; i1 < n; i1++) {
            //有书但是是0个人  它为正无穷
            f[0][i1] = Integer.MAX_VALUE;
        }
        int sum = 0;
        for (int i1 = 0; i1 <= K; i1++) {
            //k个抄写员
            for (int i2 = 0; i2 < n; i2++) {
                //n本书遍历
                f[i1][i2] = Integer.MAX_VALUE;
                sum = 0;
                for (int i3 = i2;i3>=0; i3--) {
                    //第k个抄写员，抄写那几本书使得总时间比较少
                    f[i1][i2] = Math.max(f[i1][i2],Math.max(f[i1-1][i2],sum));
                    if (i2>0){
                        sum += arr[i2-1];
                    }
                }
            }
        }
        return 0;
    }

    /*************************************************************/
    //博弈型

    /**
     * 博弈为 两方游戏
     *
     * - 一方先下，在一定规则下一次出招
     * - 如果满足一定条件，则一方胜利
     * 目标：取胜
     *
     */

    /**
     * 一排N个石子，两人轮流
     * 每次一个人都可以取走1个挥着是2个
     * 取走最后一个的人 生
     * 问先手是否取胜
     *
     *
     * 输入n=5
     * 输出true
     */
    public static boolean method4(int n){
        if (n == 0){
            return false;
        }
        if (n<=2){
            return true;
        }
        boolean f[] = new boolean[n+1] ;
        f[0] = false;
        f[1] = f[2] = true;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i-1]==false)||(f[i-2] == false);
        }
        return f[n];
    }
    public static void main(String[] args) {
//        System.out.println(mathodOne(10));
//            method2("aa");
        //3个石子，先手必bai
        System.out.println(method4(3));

        //
    }
}

























