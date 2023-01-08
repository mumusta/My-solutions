package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.List;

//Find Kth Largest Value In BST
public class FindKthLargestValueInBST {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }


    // In Order
//    private static void inOrder(BST node, List<Integer> list){
//
//        if (node == null) return;
//
//        inOrder(node.left, list);
//        list.add(node.value);
//        inOrder(node.right, list);
//    }

    // Reverse In Order is faster O(h + k)
    private static void reverseInOrder(BST node, List<Integer> list, int k){

        if (node == null || list.size() == k) return;

        reverseInOrder(node.right, list, k);
        if (list.size() < k) list.add(node.value);
        reverseInOrder(node.left, list, k);
    }

    public int findKthLargestValueInBst(BST tree, int k) {

//        List <Integer> list = new ArrayList<>();
//        inOrder(tree, list);
//        return list.get(list.size() - k);

        List <Integer> list = new ArrayList<>();
        reverseInOrder(tree, list, k);
        return list.get(list.size() - 1);
    }
}
