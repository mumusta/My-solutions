package com.mumusta.algoexpert;

import java.util.ArrayDeque;

//Invert Binary Tree
public class InvertBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    //Recursive solution
//    public static void invertBinaryTree(BinaryTree tree) {
//
//        if (tree == null) return;
//
//        BinaryTree temp = tree.left;
//        tree.left = tree.right;
//        tree.right = temp;
//
//        invertBinaryTree(tree.left);
//        invertBinaryTree(tree.right);
//    }

    //BFS solution
    public static void invertBinaryTree(BinaryTree tree) {

        ArrayDeque < BinaryTree > queue = new ArrayDeque<>();

        queue.offerLast(tree);

        while (!queue.isEmpty()){

            BinaryTree u = queue.pollFirst();

            BinaryTree temp = u.left;
            u.left = u.right;
            u.right = temp;

            if (u.left != null)
                queue.offerLast(u.left);

            if (u.right != null)
                queue.offerLast(u.right);
        }
    }
}
