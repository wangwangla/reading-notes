package com.algorithm.dongtaiguihua;

public class Fuxi {
    public static void main(String[] args) {
        int arr[] = {2,3,7};
        int arr1[][] = new int[3][4];
         //        soul(arr,27);
        soul(arr1);
    }
    public static void soul(int arr[],int target){
        int dp[] = new int[target+1];
        dp[0] = 0;
        for(int i=1;i<=target;i++){
            //为最大值表示取不到
            dp[i] =Integer.MAX_VALUE;
            for(int j = 0;j<arr.length;j++){
                if(i>=arr[j]&&dp[i-arr[j]]!=Integer.MAX_VALUE){
                    dp[i] = dp[i-arr[j]]+1;
                }
            }
        }
        System.out.println("");
    }

    public static void soul(int arr[][]){
        for(int i = 0; i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(i==0||j==0){
                    arr[i][j]=1;
                }else{
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
                }
            }
        }
        System.out.println("");
    }
    
    public void sou(int arr[],int step){
        boolean f [] = new boolean[step];
        f[0] = true;
        for (int i = 1; i <= f.length; i++) {
            for (int j = 0;j>i;j--){
                if (f[j]&&j+arr[j]>i){
                    f[j] = true;
                }
            }
        }
    }

//    public void soul1(int arr[][]){
//        int n = arr.length;
//        int dp [] = new int[n+1];
//        dp [0] =0;
//        for (int i = 1; i < n; i++) {
//            //前一个房子
//            dp[i] = Integer.MAX_VALUE;
//            for (int j = 0; j < arr[0].length; j++) {
//                //当前房子
//                for (int k = 0; k < arr[0].length; k++) {
//                    if (j!=k){
//                        if (dp[i]>dp[i-1]+arr[i-1][j]) {
//                            dp[i] = dp[i-1]
//                        }
//                    }
//                }
//            }
//        }
//    }

    public static void sourl(int arr[]){

    }

    /**
     * 将数组arr.length改为2
     * @param arr
     */
    public static void sourl1(int arr[]){
        int max = Integer.MIN_VALUE;

        int f[] = new int[arr.length];
        int i;
        for (int j = 0; j < arr.length; j++) {
            //一个值的时候为1
            f[j] = 1;
            if (j>0&&arr[j]>arr[j-1]){
                f[j] = f[j-1]+1;
            }
        }
    }

    public static int sourl2(int arr[][]){
        //临界
        if (arr == null || arr.length == 0){
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        int f[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    f[i][j] = arr[i][j];
                }else {
                    f[i][j] += Math.min(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return f[m][n];
    }



    public static int sourl3(int arr[][]){
        //临界
        if (arr == null || arr.length == 0){
            return 0;
        }
        int m = arr.length;
        int n = arr[0].length;
        int f[][] = new int[2][n];
        int one = 0;
        int two = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    f[one][j] = arr[i][j];
                }else {
                    f[one][j] += Math.min(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return f[m][n];
    }
}
