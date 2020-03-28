package com.algorithm;

import com.sun.org.apache.regexp.internal.RE;
import sun.plugin2.ipc.windows.WindowsIPCFactory;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
    //根结点
    private Node root;
    //记录树中的元素的个数
    private int N;
    //红色链接
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public boolean color;

        public Node(Key key,Value value,Node left,Node right,boolean color){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public int size(){
        return N;
    }

    public boolean isRed(Node x){
        if (x == null){
            return false;
        }
        return x.color == RED;
    }

    public Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    public Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    public void flipColor(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key,Value value){
        put(root,key,value);
        root.color = BLACK;
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null){
            N++;
            return new Node(key,value,null,null,RED);
        }
        int cmp = root.key.compareTo(key);
        if (cmp<0){
            root.left = put(root.left,key,value);
        }else if (cmp>0){
            root.right = put(root.right,key,value);
        }else {
            root.value = value;
        }
        //进行旋转
        if (!isRed(root.left)&&isRed(root.right)) {
            rotateLeft(root);
        }
        if (isRed(root.left)&&isRed(root.left.left)){
            rotateRight(root);
        }
        if (isRed(root.left)&&isRed(root.right)){
            flipColor(root);
        }
        return root;
    }

    public Node get(Key key){
        return getNode(root,key);
    }

    private Node getNode(Node root, Key key) {
        if (root==null){
            return null;
        }

        int com = root.key.compareTo(key);
        if (com < 0){
            return getNode(root.right,key);
        }
        else if (com>0){
            return getNode(root.left,key);
        }else {
            return root;
        }
    }
}
