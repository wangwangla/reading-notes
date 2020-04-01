package com.algorithm.dongtaiguihua;

/**
 * 257 组成27  最少的数字
 *
 * 解题步骤：
 *  1.需要开一个数组（一维或者二维）   确定最后一步   子问题
 *    不知道前面是什么，但是最后一部分，是27 - ak是最少
 *    ak是几不知道，只需要知道27-ak是最少的，
 *
 *    子问题：
 *    最少的用多少个硬币得到27-ak（规模减少一次）
 *    f(27) = f(27 - N)+1;
 *
 *  2.转移方程
 *    f[X] = min{f[x-2]+1,f[x-5]+1,f[x - 7]+1}
 *  3.初始条件和边界条件
 *    f[x] = min{f[x - 2]+1,f[x-5]+1,……}
 *    如果下标小于0
 *  4.计算顺序
 */
public class Question1 {

    public int digui(int x){
        if (x == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        if (x >= 2){
            res = Math.min(digui(x - 2)+1,res);
        }
        if (x >= 5){
            res = Math.min(digui(x - 5)+1,res);
        }
        if (x >= 7){
            res = Math.min(digui(x - 7)+1,res);
        }
        return res;
    }

    /**
     * ；动态规划都会创建一个数组，，遍历所右的结果，
     * f[0]作为出初始化为0.
     * 1~27
     * i>遍历数组的值
     *      >如果为true,判断取当前数组的值，之后，前面的哪个参数是否可以可以组成
     *      f[i-a[j]]是已经找过的值，它是否可以使用最少的硬币组成
     *      f[i]的值初始值比较的大，后面这个值会一直的进行更新，随着当前硬币的选择不同，会发生改变，找出最小值。
     *
     *      出是 Boolean f[] = new Boolean[m+1];//  until 27;
     *      f[0] = 0;
     *      for(i=1,i<=27;i++){
     *          找出最小值，默认设置最大
     *          f[i] = max；
     *          //遍历硬币
     *          for(int j = 0;j<n;j++){
     *              if（i>=a[j]&&f[i-a[j]]!=max&&f[i-a[j]]+1<f[i]）{
     *                  f[i] = f[i-a[j]]+1;
     *              }
     *          }
     *      }
     *
     * @param a
     * @param m
     * @return
     */
    public int coinChage(int []a,int m){
        int n = a.length;
        //0~27，需要取到27
        int f[] = new int[m+1];
        //初始化
        f[0] = 0;
        for (int i = 1; i <= m; i++) {
            f[i] = Integer.MAX_VALUE;
            //需要租成的结果
            for (int i1 = 0; i1 < n; i1++) {
                //使用硬币
                //为什么不判断i-a[i1]是不是小于0    这个题肯定是不会大于的i>[a[i1]]
                if (i>a[i1]&&f[i-a[i1]]!=Integer.MAX_VALUE&&f[i-a[i1]]+1<f[i]){
                    f[i] = f[i-a[i1]]+1;
                }
            }
        }
        if (f[m]==Integer.MAX_VALUE){
            return -1;
        }else {
            return f[m];
        }
    }

    /**
     * 机器人从00到最后一个位置的路径
     * 1.确定最后状态
     * 最后一步：通过上到下，左到右，在无其他
     * 右下标坐标（m-1）(n-1)
     * 前一步：
     *
     * 2.转移方程
     * f[i][j] = f[i-1][j]+f[i][j-1]
     *
     * 3.初始条件
     * f[0][0] = 1;
     * i = 0   j = 0  也是1
     *
     *
     */

    public int un(int m,int n){
        int [][] f = new int[m][n];
        for (int i1 = 0; i1 < m; i1++) {
            for (int i2 = 0; i2 < n; i2++) {
                if (i1==0||i2 == 0){
                    f[i1][i2] = 1;
                }else {
                    f[i1][i2] = f[i1-1][i2]+f[i1][i2-1];
                }
            }

        }
        return f[m-1][n-1];
    }

    /**
     * 如果存在障碍物
     * 障碍物出位0
     */
    public int unTwo(int arr[][],int m,int n){
        int [][] f = new int[m][n];
        for (int i1 = 0; i1 < m; i1++) {
            for (int i2 = 0; i2 < n; i2++) {
                if (arr[i1][i2] ==1){
                    f[i1][i2] = 0;
                }else {
                    if (i1 == 0 || i2 == 0) {
                        f[i1][i2] = 1;
                    } else {
                        f[i1][i2] = f[i1 - 1][i2] + f[i1][i2 - 1];
                    }
                }
            }
        }
        return f[m-1][n-1];
    }


    /**
     * 确定状态
     * 考虑最后一块石头n-1      i<n-1
     * 青蛙跳到i
     * 最后一步不可以超过最大距离  n-1-i <=ai
     *
     * 属于胜负类型
     */
    public boolean conJamp(int[]a){
        if (a==null||a.length==0){
            return false;
        }
        int n = a.length;
        boolean []f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[j]&&j+a[j]>=j){
                    f[i] = true;
                }
            }
        }
        return f[n-1];
    }

















}
