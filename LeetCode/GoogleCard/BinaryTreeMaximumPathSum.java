package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 29/08/2022
 **/

public class BinaryTreeMaximumPathSum {

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

            return -9999;
        }

        int maxLeft = solve(u.left);
        int maxRight = solve(u.right);

        result = Math.max(result, Math.max(Math.max(maxLeft + u.val, maxRight + u.val), Math.max(u.val, maxLeft + u.val + maxRight)));

        return Math.max(Math.max(maxLeft + u.val, maxRight + u.val), u.val);
    }

    public int maxPathSum(TreeNode root) {

        result = -9999;

        solve(root);

        return result;
    }
}
