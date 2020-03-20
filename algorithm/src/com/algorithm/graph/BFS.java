package com.algorithm.graph;

import com.queue.Queue;

public class BFS {
    private Queue<Integer> queue;
    private boolean []marked;
    private int count;
    
    BFS(Graph g,int v){
        queue = new Queue<>();
        marked = new boolean[g.getVerTexNum()];
        count = 0;
    }
    
    public void bfs(Graph graph,int v){
        marked[v] = true;
        queue.enqueue(v);
        while (!queue.idEmpty()){
            int wait = queue.dequeue();
            Queue<Integer> findQueue = graph.getVer(wait);
            for (Integer integer : findQueue) {
                if (!marked[integer]){
                    bfs(graph,integer);
                }
            }
        }
        count++;
    }
}
