package com.algorithm.line.stack;

import java.util.Iterator;

/**
 * 栈
 * @param <T>
 */
//一定要实现Iterable，一定要加上<T>
public class Stack<T> implements Iterable<T> {
    //记录结点
    private Node head;
    //栈中的元素
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private Node n;

        public SIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next !=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }

    private class Node{
        public T item;
        public Node next;
        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }
    public Stack(){
        this.head = new Node(null,null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        Node oldNode = head.next;
        Node newNode = new Node(t,null);
        head.next = newNode;
        newNode.next = oldNode;
        N++;
    }

    public T pop(){
        Node oldFrist = head.next;
        if (oldFrist.next == null){
            return null;
        }
        head.next = oldFrist.next;
        N--;
        return oldFrist.item;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        for (String c : stack) {
            System.out.println("输出："+c);
        }
        System.out.println("剩余size:"+stack.size());
        stack.pop();
        System.out.println("剩余size:"+stack.size());
        //stack.size().fori enter
        for (int i = 0; i < stack.size(); i++) {

        }
    }

    public boolean isMatch(String str){
        Stack<String> chars = new Stack<>();
        //遍历字符串
        for (int i = 0; i < chars.size(); i++) {
            //获取当前的字符
            String currChar = str.charAt(i) + "";
            //左括号就存起来
            if (currChar.endsWith("(")){
                chars.push(currChar);
            }else if (currChar.endsWith(")")){
                //如果是右括号有一个右括号匹配就继续，如果没有就结束
                String pop = chars.pop();
                if (pop == null){
                    return false;
                }
            }
        }
        //如果长度为0，那么就返回true，否 则就返回false;
        if (chars.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}
