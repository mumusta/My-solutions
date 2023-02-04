package com.mumusta.algoexpert;

//Find Successor
public class FindSuccessor {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    private BinaryTree findDeepestLeft(BinaryTree curr){

        if (curr.left == null) return curr;
        return findDeepestLeft(curr.left);
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {

        if (node.right != null)
            return findDeepestLeft(node.right);

        while (node.parent != null){

            if (node.parent.left != null && node.parent.left.value == node.value)
                return node.parent;

            else node = node.parent;
        }

        return null;
    }
}
