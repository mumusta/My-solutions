package com.mumusta.algoexpert;

import java.util.Arrays;

//Max Subset Sum No Adjacent
public class MaxSubsetSumNoAdjacent {

    private static int n;
    private static int[] dp;
    private static int[] list;

    //Second solution
    private static void bottomUpDP(){

        for (int i = 0; i < n; i ++){

            dp[i] = list[i];

            if ((i - 1) >= 0)
                dp[i] = Math.max(dp[i], dp[i - 1]);

            if ((i - 2) >= 0)
                dp[i] = Math.max(dp[i], dp[i - 2] + list[i]);
        }
    }

    //First solution
    private static int topDownDP(int i){

        if (i >= n) return 0;

        if (dp[i] != -1) return dp[i];

        dp[i] = Math.max(topDownDP(i + 1), topDownDP(i + 2) + list[i]);

        return  dp[i];
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {

        if (array.length == 0) return 0;

        list = array;
        n = array.length;
        dp = new int[n + 1];

//        int result = 0;
//        Arrays.fill(dp, -1);
//        result = topDownDP(0);

        bottomUpDP();

        return dp[n - 1];
    }
}
