package com.algorithm.graph;

/**
 * 无向加权
 */
public class Eade implements Comparable<Eade>{
    private final int v;
    private final int w;
    private final double weight;
    public Eade(int v,int w,double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public int eight(){
        return v;
    }

    public int other(int vertex){
        if(vertex == v){
            return w;
        }else {
            return v;
        }
    }
    @Override
    public int compareTo(Eade o) {
        if (weight>o.weight){
            return 1;
        }else if (weight<o.weight){
            return -1;
        }else {
            return 0;
        }
    }
}












