package com.algorithm.graph;

import com.queue.Queue;

/**
 * 判断是不是环
 *  1.创建一个标记，判断当前结点是不是需要进行遍历
 *  2.创建一个标记，记录当前查找点已找到的点是不是在寻找中
 *  3.成员变量
 *
 */
public class IsCyc {
    private boolean[] marked;
    private boolean[] onStack;
    private boolean isCys;
    public IsCyc(Graph graph){
        //初始化
        this.marked = new boolean[graph.getVerTexNum()];
        this.onStack = new boolean[graph.getVerTexNum()];
        this.isCys = true;
    }

    public void dfs(Graph graph,int v){
        marked[v] = true;
        onStack[v] = true;
        Queue<Integer> adj = graph.getVer(v);
        for (Integer w : adj) {
            if (marked[w]){
                dfs(graph,w);
            }
            if (onStack[w]){
                this.isCys = true;
                return ;
            }
        }
        onStack[v] = false;
    }

    public boolean isCys() {
        return isCys;
    }
}
