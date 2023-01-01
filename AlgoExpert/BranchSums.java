package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {

        List < Integer > res = new ArrayList<>();

        solve(root, 0, res);

        return res;
    }

    public static void solve(BinaryTree curr, int sum, List < Integer > list){

        if (curr == null) return;

        if (curr.left == null && curr.right == null){

            list.add(sum + curr.value);
            return;
        }

        solve(curr.left, sum + curr.value, list);
        solve(curr.right, sum + curr.value, list);
    }
}
