package com.mumusta.algoexpert;

//Merge Binary Trees
public class MergeBinaryTrees {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    private void solveIt(BinaryTree tree2, BinaryTree tree1){

        tree1.value += tree2.value;

        if (tree2.left != null){

            if (tree1.left == null) tree1.left = new BinaryTree(0);

            solveIt(tree2.left, tree1.left);
        }

        if (tree2.right != null){

            if (tree1.right == null) tree1.right = new BinaryTree(0);

            solveIt(tree2.right, tree1.right);
        }
    }

    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {

        if (tree1 == null && tree2 == null) return null;
        if (tree2 == null) tree2 = new BinaryTree(0);
        if (tree1 == null) tree1 = new BinaryTree(0);

        solveIt(tree2, tree1);

        return tree1;
    }
}
