package com.algorithmfuxi.tree;

import com.algorithm.bina.BinaryTree;

import java.util.Objects;

public class BinTree<T extends Comparable> {
    private class Node<T>{
        private T t;
        private Node left;
        private Node right;
        public Node(T t,Node left,Node right){
            this.t = t;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;
//    public BinTree(){
//        root = new Node(null,null,null);
//    }
     public void insert(T t){
//         if (root==null){
//             root = new Node(t,null,null);
//             return;
//         }
         root = insert(root,t);
     }

    private Node insert(Node root, T t) {
         if (root == null){
             return root = new Node(t,null,null);
         }
         if (t.compareTo(root.t)>0){
             root.left = insert(root.left,t);
         }else if (t.compareTo(root.t)<0){
             root.right = insert(root.right,t);
         }else {
             root.t = t;
         }
         return root;
    }

    public void printQ(Node root){
        if (root == null){
            return;
        }
        System.out.println(root.t);
        printQ(root.left);
        printQ(root.right);
    }

    public void printZ(Node root){
        if (root == null){
            return;
        }
        printZ(root.left);
        printZ(root.right);

        System.out.println(root.t);
     }

    public void printH(Node root){
        if (root == null){
            return;
        }
        printH(root.left);
        printH(root.right);

        System.out.println(root.t);
    }

    public void delete(T t){
         delete(root , t);

    }

    private Node delete(Node root, T t) {
         if (root == null){
             return null;
         }
         //找到结点
        if (t.compareTo(root.t)<0){
            root.left = delete(root,t);
        }else if (t.compareTo(root.t)>0){
            root.right = delete(root,t);
        }else {
            //找到之后
            //左右子树是不是为null
            if (root.right == null){
                return root.left;
            }
            if (root.left ==null){
                return root.right;
            }
            //如果都有，那么就先去找右子树的左子树
            Node rNode = root.right;
            while (rNode.left!=null){
                rNode = rNode.left;
            }
            Node n = rNode.right;
            while (n.left!=null){
                if (n.left.left==null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }
        }
         return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinTree)) return false;
        BinTree<?> tree = (BinTree<?>) o;
        return Objects.equals(root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    public static void main(String[] args) {
        BinTree tree = new BinTree();
        tree.insert(3);
        tree.insert(4);
        tree.insert(34);
        tree.insert(42);
        tree.insert(36);
        tree.insert(45);
        tree.insert(31);
        tree.insert(47);
        tree.insert(33);
        tree.insert(40);

        tree.printH(tree.root);
    }
}
