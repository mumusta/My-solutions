package com.mumusta.algoexpert;

public class FindClosestValueInBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target) {

        int res = tree.value;

        while (tree != null){

            if (Math.abs(target - tree.value) < Math.abs(target - res))
                res = tree.value;

            if (tree.value < target)
                tree = tree.right;

            else if (tree.value > target)
                tree = tree.left;

            else break;
        }

        return res;
    }


//    public static int findClosestValueInBst(BST tree, int target) {
//
//        if (tree == null)
//            return Integer.MAX_VALUE;
//
//        int res = tree.value;
//
//        if (target < tree.value && tree.left != null){
//
//            int left = findClosestValueInBst(tree.left, target);
//
//            if (Math.abs(target - left) < Math.abs(target - res))
//                res = left;
//        }
//
//        else if (target > tree.value && tree.right != null){
//
//            int right = findClosestValueInBst(tree.right, target);
//
//            if (Math.abs(target - right) < Math.abs(target - res))
//                res = right;
//        }
//
//        return res;
//    }
}
