package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 29/08/2022
 **/

public class CountCompleteTreeNodes {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int countNodes(TreeNode root) {

        if (root == null){
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
