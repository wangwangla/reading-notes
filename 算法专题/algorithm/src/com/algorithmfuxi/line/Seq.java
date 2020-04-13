package com.algorithmfuxi.line;

import java.util.Iterator;

public class Seq<T> implements Iterable<T> {
    private T[] elements;
    private int N;
    public Seq(){
        elements = (T[]) new Object[10];
        this.N = 0;
    }
    public Seq(int capacity){
        elements = (T[])new Object[capacity];
        this.N = 0;
    }
    public void clear(){
        //为了赶紧释放
        for (T element : elements) {
            element = null;
        }
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

    public void insert(T t,int index){
        for (int i = N; i > index-1; i--) {
            elements[i] = elements[i-1]; 
        }
        elements[index-1] = t;
        N ++;
    }

    public void delete(int index){
        for (int j = index-1; j < N-1; j++) {
            elements[j] = elements[j+1];
        }
        N--;
    }

    public void checkIndex(int index){
        
    }

    public static void main(String[] args) {
        Seq s = new Seq<Integer>();
        s.insert(2);
        s.insert(3);
        s.insert(5,2);
        s.delete(1);
        Iterator iterator = s.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Override
    public Iterator iterator() {
        return new It();
    }

    private class It implements Iterator{
        private int index;
        @Override
        public boolean hasNext() {
            return index<N;
        }

        @Override
        public T next() {
            return elements[index++];
        }
    }
}
