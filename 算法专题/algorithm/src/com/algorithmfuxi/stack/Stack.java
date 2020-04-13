package com.algorithmfuxi.stack;

public class Stack<T> {
    private int length;
    private T element[];

    public Stack(int capacity){
        element = (T[])new Object[capacity];
        this.length = -1;
    }

    public void insert(T t){
        element[++length] = t;
    }

    public T pop(){
        return element[length--];
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.insert("3");
        stack.insert("32");
        stack.insert("6");
        stack.insert("4");
        int lenth = stack.getLength();
        for (int i = 0; i <= lenth; i++) {
            System.out.println(stack.pop());
        }
    }
}
