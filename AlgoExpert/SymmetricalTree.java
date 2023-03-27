package com.mumusta.algoexpert;

public class SymmetricalTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    private boolean isSymmetrical;

    private void solveIt(BinaryTree left, BinaryTree right){

        if (left == null && right == null) return;
        if (left == null || right == null) {

            isSymmetrical = false;
            return;
        }

        if (left.value != right.value)
            isSymmetrical = false;

        solveIt(left.left, right.right);
        solveIt(left.right, right.left);
    }

    public boolean symmetricalTree(BinaryTree tree) {

        isSymmetrical = true;
        solveIt(tree, tree);

        return isSymmetrical;
    }
}
