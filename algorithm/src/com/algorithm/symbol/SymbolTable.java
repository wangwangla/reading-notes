package com.algorithm.symbol;

/**
 * 符号存储的是key  value
 * @param <Key>
 * @param <Value>
 */
public class SymbolTable<Key extends Comparable,Value> {
    private Node head;
    private int N;
    private class Node{
        public Key key;
        public Value value;
        public Node next;

        public Node(Key key,Value value,Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SymbolTable(){
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public void put(Key key,Value value){
        //如果存在这个key
        Node n = head;
        while (n.next!=null){
            n = n.next;
            if (key.equals(n.key)){
                n.value = value;
                return;
            }
        }
        //如果不存在这个key
        Node newNode = new Node(key,value,null);
        Node oldNode = head.next;
        newNode.next = oldNode;
        head.next = newNode;
        N++;
    }

    public void order(Key key,Value value){
        Node curr = head.next;
        Node pre = head;
        while (curr!=null&&key.compareTo(curr.key)>0){
            pre = curr;
            curr = curr.next;
        }
        if (curr!=null&&key.compareTo(curr.key)==0){
            curr.value = value;
            return;
        }
        Node newNode = new Node(key,value,curr);
        pre.next = newNode;
        N++;
    }

    public void delete(Key key){
        Node n = head;
        while (n.next!=null){
//            n=n.next;为什么不这么做，这么做是自己怎么办
            if (n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }

    public boolean isEmpty(){
        return false;
    }

    public int size(){
        return N;
    }
}
