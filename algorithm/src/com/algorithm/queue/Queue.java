package com.algorithm.queue;

import org.omg.CORBA.Object;

public class Queue<T> {
    private T item[];
    private int N;
    private int front;
    private int rear;
    private int maxSize;
    public Queue(int num){
        this.maxSize = num;
        this.item = (T[])new Object[num];
        this.N = 0;
        this.front = -1;
        this.rear = -1;
    }


    private boolean isFull(){
        return N == maxSize-1;
    }

    private boolean isEmpty(){
        return front == rear;
    }
}
