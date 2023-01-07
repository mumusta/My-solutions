package com.mumusta.algoexpert;

public class ValidateBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    static class Result{

        public int maximum;
        public int minimum;
        public boolean isBST;

        public Result(){

            isBST = true;
            maximum = Integer.MIN_VALUE;
            minimum = Integer.MAX_VALUE;
        }
    }

    public static Result validateBstHelper(BST currentNode){

        if (currentNode == null) return new Result();

        Result result = new Result();
        Result left = validateBstHelper(currentNode.left);
        Result right = validateBstHelper(currentNode.right);
        result.maximum = Math.max(currentNode.value, Math.max(left.maximum, right.maximum));
        result.minimum = Math.min(currentNode.value, Math.min(left.minimum, right.minimum));
        result.isBST = (left.maximum < currentNode.value) & (currentNode.value <= right.minimum) & left.isBST & right.isBST;

        return result;
    }

    public static boolean validateBstHelperTwo(BST currentNode, int lessThan, int greaterThanOrEqual){

        if (currentNode == null) return true;
        if (currentNode.value >= lessThan || currentNode.value < greaterThanOrEqual) return false;

        return validateBstHelperTwo(currentNode.left, currentNode.value, greaterThanOrEqual) &&
               validateBstHelperTwo(currentNode.right, lessThan, currentNode.value);
    }

    public static boolean validateBst(BST tree) {

        //The first is his solution, the second is mine, both solutions work anyway.

        return validateBstHelperTwo(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
        //return validateBstHelper(tree).isBST;
    }

    public static void main(String[] args) {

        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.left.left.left = new BST(1);
        tree.right.left = new BST(13);
        tree.right.right = new BST(22);
        tree.right.left.right = new BST(16);

        BST tree2 = new BST(10);
        tree2.right = new BST(10);
        tree2.right.left = new BST(10);
        tree2.right.right = new BST(10);
        tree2.left = new BST(9);

        BST tree3 = new BST(15);
        tree3.left = new BST(13);
        tree3.right = new BST(22);
        tree3.left.right = new BST(16);

        System.out.println(validateBst(tree3));
    }
}
