package com.algorithm.line.sequence;

import java.util.Objects;

/**
 * 线性表
 * @param <T>
 */
public class SequenceList<T> {
    private T[] elements;
    private int N;
    public SequenceList(){
            elements = (T[]) new Object[10];
    }
    public SequenceList(int capacity){
        elements = (T[]) new Object[capacity];
        this.N = 0;
    }
    public void clear(){
        this.N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public T get(int i){
        return elements[i];
    }

    public void insert(T t){
        elements[N++] = t;
    }

    public void insert(int i,T t){
        for (int j = N; j > i ; j--) {
            elements[j] = elements[j-1];
        }
        elements[i] = t;
    }

    public void delete(int index){
        for (int i = index; i < N; i++) {
            elements[i-1] = elements[i];
        }
    }

    public void checkIndex(int index){
        if(index>=N){
            throw new RuntimeException("this "+ index + "out of size! ");
        }
    }
}
