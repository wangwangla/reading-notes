package com.algorithm.graph;

import com.queue.Queue;

public class Graph {
    //顶点个数
    private int verTexNum;
    //边的个数
    private int lineNum;
    //邻接表
    private Queue<Integer>[] queue;

    public Graph(int v){
        this.verTexNum = v;
        this.lineNum = 0;
        queue = new Queue[v];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new Queue<>();
        }
    }

    public int getVerTexNum() {
        return verTexNum;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void addEage(int v,int w){
        queue[v].enqueue(w);
        queue[w].enqueue(v);
        lineNum++;
    }
    public Queue<Integer> getVer(int v){
        return queue[v];
    }
}
