package com.letcode;

import java.util.ArrayList;

public class Question24 {
    ArrayList<Node> arrayList = new ArrayList();
    class Node {
        private int x;
        public Node left;
        public Node right;
    }
    public void mide(Node root){
        mide(root.left);
        arrayList.add(root);
        mide(root.right);
    }

    public void so(){
        int x = arrayList.get(0).x;
        for (int i = 0; i < arrayList.size()-1; i++) {
            Node node = arrayList.get(arrayList.size()-2-i);
            node.x = node.x +x;
        }
    }
}
