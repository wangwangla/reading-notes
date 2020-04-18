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
 *
 *  3.初始条件和边界条件
 *    f[x] = min{f[x - 2]+1,f[x-5]+1,……}
 *    如果下标小于0
 *
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
     * 如果存在障碍物                坐标型
     * 障碍物出位0
     */
    public int unTwo(int arr[][],int m,int n){
        if (m==0||n==0)return 0;
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
                //可以跳到   第j个首先可以跳到，j+当前值需要大于
                if (f[j]&&j+a[j]>=i){
                    f[i] = true;
                }
            }
        }
        return f[n-1];
    }

    /**
     * 序列
     *
     *
     * 房子染色问题，相邻的房子颜色不相同
     */
    public int minCost(int[][] costs){
        int n = costs.length;//房子的个数
        //如果房子个数为0，就返回0
        if (n == 0){
            return 0;
        }
        //创建数组，记录数值   0作为初始化，n个房子，考虑是前n-1,n-2,所以计算到N+1，才可以计算到N
        int f[][]=new int[n+1][3];
        for (int i = 1; i < n; i++) {
            //n-1房子
            for (int j = 0; j < 3; j++) {
                f[i][j] = Integer.MAX_VALUE;
                //n-2房子
                for (int k = 0; k < 3; k++) {
                    //不能让他们一样
                    if (j==k){
                        continue;
                    }
                    //找出前两个的最小值   说是记录前两个颜色，其实就是本次染色和上次染色，  本次和上次颜色不一样
                    if (f[i-1][k]+costs[i-1][j]<f[i][j]){
                        //前一个房子使用k颜色  当前使用j颜色
                       f[i][j] = f[i-1][k]+costs[i-1][j];
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 解码的问题  A->z 对应的是1-26  输入一长串数字字符串，求出共有多少解码方式
     *
     * 都只可以解析成一位，那么就只有一种结果
     * 有两位了结果就会增加。
     */
    public int soultion(){
        String str = "";
        char[] arr = str.toCharArray();
        //计算出长度
        int length = arr.length;
        if (length == 0){
            return 1;
        }
        //创建一个数组存储 每个字符处的个数     0不使用   1~length
        int f [] = new int[length+1];
        f[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            //取出每一位   123234332
            int temp = arr[i] - '0';//字符变为数字
            f[i] = 0;
            //因为单个0 没意义
            if (temp>=1){
                f[i] += f[i-1];
            }
            if (i>1){
                //如果是两位值  现在需要将两位数据转换为整数，是不是在1~26范围内
                int num = f[i-2]*10+f[i-1];
                if (num>0&&num<27){
                    f[i] = f[i]+f[i-2];
                }
            }
        }
        return f[length];
    }

    /**
     * 求出最长的递增字串
     *
     * 从1开始，f可以从0 开始
     * f[0] = 1;
     * if(a[i]>a[i-1])  f[i] +=1;
     * else f[i] =0 ;
     * 数组
     *      找出最长递增字串
     *      12345 ——>  5
     *      51234 ——>  4
     */
    public int length(int a[]){
        if (a.length <2) {
            return 1;
        }
        f(a);
        //反转数组
        f(a);
        return 0;
    }
    private int max = 0;
    public void f(int a[]){
        int f [] = new int[a.length];
        f[0] = 1;
        for (int i = 1; i < a.length; i++) {
            f[i] = 1;
            if (a[i]>a[i-1]){
                f[i] = f[i-1]+1;
            }
        }
        for (int i = 0; i < f.length; i++) {
            if (max > f[i]){
                max = f[i];
            }
        }
    }
    /**
     * 所走的路径，和最短
     *
     * 创建二位数组
     *
     * if(i=1||j=0){
     *     f[i][j] = A[i][j];
     * else
     *    f[i][j] = min(f[i-1][j],f[i][j-1])+A[i][j]
     * }
     *
     *
     * new记录本次值
     * old记录上次的值
     * */
    public int minP(int [][]arr){
        if (arr==null||arr.length == 0||arr[0].length==0){
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        int [][]f = new int[2][n];
        int old = 1;
        int now = 0;
        for (int i = 0; i < m; i++) {
            old = now;
            now = 1-old;
            for (int i1 = 0; i1 < n; i1++) {
                f[now][i1] = arr[i][i1];
                if (i==0&&i1 == 0){
                    continue;
                }
                //不是第一个位置的，
            }
        }
        return 0;
    }

    /**
     * 所走的路径，和最短
     *
     * 创建二位数组
     *
     * if(i=1||j=0){
     *     f[i][j] = A[i][j];
     * else
     *    f[i][j] = min(f[i-1][j],f[i][j-1])+A[i][j]
     * }
     */
    public void tets(){
        int arr[][] = new int[10][10];
        if (arr!=null&&(arr.length==0||arr[0].length==0)){
            return;
        }
        int [][] f= new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[0].length; i1++) {
                if (i==0||i1==0){
                    f[i][i1] = arr[i][i1];
                }else {
                    f[i][i1] = Math.min(f[i-1][i1],f[i][i1-1])+arr[i][i1];
                }
            }
        }
        System.out.println(f[arr.length-1][arr[0].length]);
    }

    public static void test(){
        int arr[][] = {{0,0,0},{0,0,0},{0,0,0}};
        int n = arr.length;
        int m = arr[0].length;
        if (n==0||m == 0){
            return;
        }
        int f [][] = new int[n][m];
        f[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < m; i1++) {
                if (arr[i][i1] == 1){
                    f[i1][i] = 0;
                }else {
                    if (i==0||i1==0){
                        f[i][i1] = 1;
                    }else
                    f[i][i1] = f[i-1][i1]+f[i][i1-1];
                }
            }
        }
        System.out.println(f[n-1][m-1]);
    }

    public void paintHouse(int arr[][]){
        //房子个数
        int numHouse = arr.length;
        int f[][] = new int[numHouse+1][3];
        f[0][0]=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                for (int k = 0; k < arr[0].length; k++) {
                   if (j == k){
                       continue;
                   }
                   f[i][j] = Integer.MAX_VALUE;
                   //上一个的花费    上上一个花费
                   if (arr[i-1][k]+f[i-1][j]<f[i][j]){
                       f[i][j] = arr[i-1][k]+f[i-1][j];
                   }
                }
            }
        }
//        最后一步找出最大值
    }

    public void jiemi(String str){
        char[] chars = str.toCharArray();
        int len = chars.length;
        int f[] = new int[len];
        if (len == 0)return;
        f[0] = 1;
        for (int i = 0; i < len; i++) {
//            int num =
        }
    }

    public static void oneNum(){
        int num =  10;
        int f[] = new int[num+1];
        f[0] = 0;
        int i;
        for (int i1 = 0; i1 < num; i1++) {
            f[i1] = f[i1>>1] + (i1%2);
            System.out.println(f[i1]+" "+i1);
        }

    }

    public static void main(String[] args) {
//        test();
        oneNum();
    }

    /**
     * 一列数据，求出最小值，去掉某个值之后的最小值
     * */

    public int paintHouse1(int arr[][]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        int K = arr[0].length;
        int [][]f = new int[n+1][K];
        int min1,min2;
        int j1=0,j2 = 0;
        int i,j,k;
        for (j = 0; j < K; j++) {
            f[0][j] = 0;
        }
        for (i = 0; i < n; i++) {
            min1 = min2 = Integer.MAX_VALUE;
            for (j = 0; j < K; j++) {
                if(f[i-1][j] < min1){
                    min2 = min1;
                    min1 = f[i-1][j];
                    j2 = j1;
                    j1 = j;
                }else {
                    if (f[i - 1][j] < min2) {
                        min2 = f[i - 1][j];
                        j2 = j;
                    }
                }
            }
            for (j = 0; j < K; j++) {
                if (j!=i){
                    f[i][j] = f[i-1][j1] + arr[i-1][j];
                }else {
                    f[i][j] = f[i-1][j2] + arr[i-1][j];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (j = 0; j < K; j++) {
            res = Math.min(res,f[n][j]);
        }
        return 0;
    }
}





















