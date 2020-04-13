package com.algorithm.uf;

public class UFyouhua {
    //记录结点元素设分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;
    //初始化并查集
    public UFyouhua(int N){
        this.count = N;
        //初始第一步，告知一共有多少个结点
        eleAndGroup = new int[N];
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public int find(int n){
        while (true){
            if (n == eleAndGroup[n]){
                return n;
            }
            n = eleAndGroup[n];
        }
    }

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    public void union(int q,int p){
        int pGroup = find(p);
        int qGroup = find(q);
        if (qGroup==pGroup){
            return;
        }
        eleAndGroup[qGroup] = pGroup;
        count--;

    }
}
