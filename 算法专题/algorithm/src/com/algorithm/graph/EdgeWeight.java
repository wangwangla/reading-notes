//package com.algorithm.graph;
//
//import com.queue.Queue;
//
//public class EdgeWeight {
//    private final int V;
//    private int E;
//    private Queue<Eade>[] adj;
//
//    public EdgeWeight(int V){
//        this.V =  V;
//        this.E = 0;
//        this.adj = new Queue[V];
//        for (Queue<Eade> eadeQueue : adj) {
//            eadeQueue = new Queue<Eade>();
//        }
//    }
//
//    public int V(){
//        return V;
//    }
//
//    public int E(){
//        return E;
//    }
//    public void addEdge(Eade e){
//        int v = e.eight();
//        int w = e.other(v);
//        adj[v].enqueue(e);
//        adj[w].enqueue(e);
//        E++;
//    }
//
//    public Queue<Eade> adj(int v){
//        return adj[v];
//    }
//
//    public Queue<Eade> edges(){
//        Queue<Eade> eades = new Queue<>();
//        for (int i = 0; i < V; i++) {
//            for (Eade eade : adj(i)) {
//                if (eade.other(i)<i){
//                    eades.enqueue(eade);
//                }
//            }
//        }
//    }
//}
//
