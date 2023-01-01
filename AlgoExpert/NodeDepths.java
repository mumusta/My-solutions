package com.mumusta.algoexpert;

public class NodeDepths {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int solve(BinaryTree curr, int length){

        if (curr == null) return  0;

        return length + solve(curr.left, length + 1) + solve(curr.right, length + 1);
    }

    public static int nodeDepths(BinaryTree root) {

        return solve(root, 0);
    }
}
