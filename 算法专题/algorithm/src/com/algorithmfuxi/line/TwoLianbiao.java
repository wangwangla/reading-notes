package com.algorithmfuxi.line;

public class TwoLianbiao<T> {
    private class Node{
        private T item;
        private Node pre;
        private Node next;
        public Node(T item,Node pre,Node next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    private Node head;
    private Node last;
    private int N;

    public TwoLianbiao(){
        this.head = new Node(null,null,null);
        this.last = null;
        this.N = 0;
    }

    public void clear(){
        this.head.next = null;
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public T getFrist(){
        if (isEmpty()){
            return null;
        }
        return head.next.item;
    }

    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.item;
    }

    public void insert(T t){
        if(isEmpty()){
            //如果为null，
            //创建新结点
            Node node = new Node(t,head,null);
            //新结点变为为节点
            last = node;
            head.next = last;
        }else {
            Node oldLast = last;
            Node newNode = new Node(t,oldLast,null);
            oldLast.next = newNode;
            last = newNode;
        }
        N++;
    }

    public void insert(int i,T t){
        Node pre = head;
        for (int j = 0; j < i; j++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node node = new Node(t,pre,curr);
        pre.next = node;
        curr.pre = node;
        N++;
    }

    public void delete(int t){
        Node node = head;
        for (int i = 0; i < N; i++) {
            node = node.next;
            if (node.item.equals(t)){
                break;
            }
        }
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        N--;

    }
}

