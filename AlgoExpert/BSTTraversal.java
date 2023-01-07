package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {

        if (tree == null) return array;

        inOrderTraverse(tree.left, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {

        if (tree == null) return array;

        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);

        return array;
    }

    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {

        if (tree == null) return array;

        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);

        return array;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    // BST Traversal
    public static void main(String[] args) {

        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.left.left.left = new BST(1);
        tree.right.right = new BST(22);

        System.out.println(inOrderTraverse(tree, new ArrayList<>()));
        System.out.println(preOrderTraverse(tree, new ArrayList<>()));
        System.out.println(postOrderTraverse(tree, new ArrayList<>()));
    }
}
