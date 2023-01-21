package com.mumusta.algoexpert;

//Binary Tree Diameter
public class BinaryTreeDiameter {

    private int longestPath = 0;

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    private int helper(BinaryTree currentNode){

        if (currentNode == null) return 0;

        int left = helper(currentNode.left),
                right = helper(currentNode.right);

        longestPath = Math.max(longestPath, left + right);

        return 1 + Math.max(left, right);
    }

    public int binaryTreeDiameter(BinaryTree tree) {

        helper(tree);

        return longestPath;
    }
}
