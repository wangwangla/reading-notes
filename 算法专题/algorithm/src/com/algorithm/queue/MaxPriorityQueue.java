package com.algorithm.queue;

/**
 * 为了可以适应所以类型的数据，所以适应泛型，为了可以比较我们需要实现比较接口
 *
 */
public class MaxPriorityQueue<T extends Comparable>{
    //使用数组来存储
    private T[] item;
    //使用一个N来记录个数
    private int N;
    public MaxPriorityQueue(int capacity){
        this.item = (T[])new Comparable[capacity+1];
        this.N = 0;
    }

    public boolean isEmpty(){
        return N==0;
    }
    //判断索引i是否小于索引j的元素
    private boolean less(int i,int j){
        return item[i].compareTo(item[j])<0;
    }
    public void exch(int i,int j){
        T temp = item[i];
        item[i] = item[j];
        item[j] = temp;
    }

    public void insert(T t){
        item[++N] = t;
        swim(N);
    }

    private void swim(int n) {
        while (n>1){
            if (less(n/2,n)){
                exch(n/2,n);
            }
            n = n/2;
        }
    }

    public T delMax(){
        T max = this.item[1];
        exch(1,N);
        this.item[N] = null;
        N--;
        sink(N);
        return max;
    }

    private void sink(int n) {
        while (2*n<=N){
            int max;
            if(2*n+1<=N){
                if(less(2*n,2*n+1)){
                    max = 2*n+1;
                }else {
                    max = 2*n;
                }
            }else {
                max = 2*n;
            }

            if (less(n,max)){
                exch(n,max);
            }else {
                break;
            }
            n*=2;
        }
    }

}
