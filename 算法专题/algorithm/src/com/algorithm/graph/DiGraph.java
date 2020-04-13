package com.algorithm.graph;

import com.queue.Queue;

public class DiGraph {
    private final int V;
    private int E;
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
}
