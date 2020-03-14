package com.algorithm.bina;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    private Node root;
    private int N;
    private class Node{
        public Key key;
        private Value value;
        public Node left;
        public Node right;
        public Node(Key key,Value value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right= right;
        }
    }

    public int size(){
        return N;
    }

    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    public Node put(Node x,Key key,Value value){
        if (x == null){
            N++;
            return new Node(key,value,null,null);
        }
        int comTemp = key.compareTo(x.key);
        if (comTemp>0){
            x.right = put(x.right,key,value);
        }else if (comTemp<0){
            x.left = put(x.left,key,value);
        }else {
            x.value = value;
        }
        return x;
    }

    public Value get(Key key){
        return get(root,key);
    }

    private Value get(Node root, Key key) {
        if (root == null){
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp > 0){
            return get(root.right,key);
        }else if (cmp<0){
            return get(root.left,key);
        }else {
            return root.value;
        }
    }

    public void delete(Key key){
        delete(root,key);
    }

    private Node delete(Node root, Key key) {
        //如果未null就返回null
        if (root == null){
            return null;
        }
        //不为null,就进行查找，最终目的时找出相等的值
        int cmp = key.compareTo(root.key);
        if (cmp > 0){
            root.right = delete(root.right,key);
        }else if  (cmp > 0){
            root.left = delete(root.left,key);
        }else {
            //找到相等的值
            N --;
            //如果左子树未null，就返回右子树
            if (root.right==null){
                return root.left;
            }
            if (root.left==null){
                return root.right;
            }

            Node minNode = root.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }
            Node n = root.right;
            while (n.left!=null){
                if (n.left.left==null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree<Integer,String> binaryTree = new BinaryTree<>();
        binaryTree.put(1,"a");
        binaryTree.put(2,"b");
        binaryTree.put(3,"c");
        binaryTree.put(4,"d");
        System.out.printf("输出："+binaryTree.size());
        binaryTree.delete(2);
        System.out.println(binaryTree.size());
    }
}
