package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 29/08/2022
 **/

public class DiameterOfBinaryTree {

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

    private static int result;

    private static int solve(TreeNode u){

        if (u == null){
            return 0;
        }

        int leftMax = solve(u.left), rightMax = solve(u.right);

        result = Math.max(result, 1 + leftMax + rightMax);

        return Math.max(1 + leftMax, 1 + rightMax);
    }

    public int diameterOfBinaryTree(TreeNode root) {

        result = 0;

        solve(root);

        return result - 1;
    }
}
