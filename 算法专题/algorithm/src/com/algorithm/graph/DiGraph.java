package com.algorithm.graph;

import com.queue.Queue;

/**
 * 使用邻接表的方式存储
 *
 */
public class DiGraph {
    //顶点的数量
    private final int V;
    //边的数量
    private int E;
//    点与几个点相连
    private Queue<Integer>[] queue;

    public DiGraph(int num){
        this.V = num;
        this.E = 0;
        queue = new Queue[num];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new Queue<>();
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(int v,int w){
        queue[v].enqueue(w);
        this.E++;
    }

    public DiGraph reverse(){
        DiGraph r = new DiGraph(V);
        for (int i = 0; i < V; i++) {
            for (Integer w : queue[i]){
                r.addEdge(w,i);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        DiGraph diGraph = new DiGraph(10);
        diGraph.addEdge(0,1);
        diGraph.addEdge(1,1);
        diGraph.addEdge(4,1);
        diGraph.addEdge(2,1);
        diGraph.addEdge(6,1);
        diGraph.addEdge(8,1);

    }
}
