package com.mumusta.algoexpert;

import java.util.List;

//Min Height BST
public class MinHeightBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {

            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }


//            Without using the insert function

//    public static void helper(BST currentNode, int left, int right, List<Integer> array){
//
//        if (left > right) return;
//
//        int length = right - left + 1, mid = left + (length / 2);
//
//        currentNode.value = array.get(mid);
//
//        if (left < mid){
//
//            currentNode.left = new BST(0);
//            helper(currentNode.left, left, mid - 1, array);
//        }
//
//        if (mid < right){
//
//            currentNode.right = new BST(0);
//            helper(currentNode.right, mid + 1, right, array);
//        }
//    }


//           Using the insert function
    private static void helper(BST root, int left, int right, List<Integer> array, boolean isFirst){

        if (left > right) return;

        int length = right - left + 1, mid = left + (length / 2);

        if (isFirst) root.value = array.get(mid);
        else root.insert(array.get(mid));

        if (left < mid){

            helper(root, left, mid - 1, array, false);
        }

        if (mid < right){

            helper(root, mid + 1, right, array, false);
        }
    }

    public static BST minHeightBst(List<Integer> array) {

        BST root = new BST(0);
        //helper(root, 0, array.size() - 1, array);
        helper(root, 0, array.size() - 1, array, true);

        return root;
    }
}
