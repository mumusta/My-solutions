package com.mumusta.algoexpert;

//Height Balanced Binary Tree
public class HeightBalancedBinaryTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    private boolean isHeightBalancedBinaryTree = true;

    private int heightOfSubTree(BinaryTree current){

        if (current == null) return 1;

        int left = heightOfSubTree(current.left);
        int right = heightOfSubTree(current.right);

        isHeightBalancedBinaryTree &= (Math.abs(left - right) <= 1);

        return Math.max(left, right) + 1;
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {

        heightOfSubTree(tree);
        return isHeightBalancedBinaryTree;
    }
}
