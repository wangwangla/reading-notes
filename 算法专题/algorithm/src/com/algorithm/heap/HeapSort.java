package com.algorithm.heap;

import com.sun.xml.internal.ws.api.BindingID;

public class HeapSort<T extends Comparable<T>> {
    public boolean less(Comparable[] heap ,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }

    public void exch(Comparable[] heap,int i,int j){
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    
    public void createHeap(Comparable[]source,Comparable[] target){
        System.arraycopy(source,0,target,1,source.length);
        for (int i = target.length/2;i>0 ;i--) {
            sink(target,i,target.length-1);
        }
    }

    private void sink(Comparable[] target, int start, int range) {
        while (2*start<=range){
            int max;
            if (2*start+1<range){
                if (less(target,2*start,2*start+1)){
                    max = 2*start+1;
                }else {
                    max = 2*start;
                }
            }else {
                max = 2*start;
            }
            if (!less(target,start,max)){
                break;
            }
            exch(target,start,max);
            start = max;
        }
    }
    public void sort(Comparable[] source){
        Comparable[] heap = new Comparable[source.length+1];
        createHeap(source,heap);
        int N = heap.length - 1;
        while (N!=1){
            exch(heap,1,N);
            N--;
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source,0,source.length);
    }

}
