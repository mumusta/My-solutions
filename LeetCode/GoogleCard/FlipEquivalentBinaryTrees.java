package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 29/08/2022
 **/


public class FlipEquivalentBinaryTrees {

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

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        if (root1.left != null){

            if (root1.right == null){

                root1.right = root1.left;
                root1.left = null;
            }

            else {

                if (root1.left.val > root1.right.val){
                    TreeNode temp = root1.right;
                    root1.right = root1.left;
                    root1.left = temp;
                }
            }
        }

        if (root2.left != null){

            if (root2.right == null){

                root2.right = root2.left;
                root2.left = null;
            }

            else {
                if (root2.left.val > root2.right.val){
                    TreeNode temp = root2.right;
                    root2.right = root2.left;
                    root2.left = temp;
                }
            }
        }

        return flipEquiv(root1.left, root2.left) & flipEquiv(root1.right, root2.right);
    }

}
