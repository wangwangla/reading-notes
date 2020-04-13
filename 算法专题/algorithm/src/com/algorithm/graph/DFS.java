package com.algorithm.graph;

public class DFS {
    //标记图的结点
    private boolean[] marked;
    //一共有多少是相通的。
    private int count;
    DFS(Graph g,int s){
        this.marked = new boolean[g.getVerTexNum()];
        count = 0;
    }

    public void dfs(Graph g,int s){
        marked[s] = true;
        for (int i = g.getVer(s).size() - 1; i >= 0; i--) {
            if (!marked[i]){
                dfs(g, g.getVer(s).dequeue());
            }
        }
    }
}
