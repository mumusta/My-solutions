package com.mumusta.algoexpert;

import java.util.Arrays;

//Number Of Ways To Make Change
public class NumberOfWaysToMakeChange {

    private static int d;
    private static int[] list;
    private static int[][] dp;

    //First solution
    private static int topDownDP(int i, int remainder){

        if (i == d){

            if (remainder == 0) return 1;
            else return 0;
        }

        if (dp[i][remainder] != -1) return dp[i][remainder];

        dp[i][remainder] = topDownDP(i + 1, remainder);

        if (remainder >= list[i]){

            dp[i][remainder] += topDownDP(i, remainder - list[i]);
        }

        return dp[i][remainder];
    }

    //Second solution
    private static int bottomUpDP(int n){

        for (int i = 0; i < d; i ++)
            dp[i][0] = 1;

        for (int i = 0; i < d; i ++){

            int currentCoin = list[i];

            for (int remainder = 1; remainder <= n; remainder ++){

                if (i > 0)
                    dp[i][remainder] += dp[i - 1][remainder];

                if (remainder >= currentCoin)
                    dp[i][remainder] += dp[i][remainder - currentCoin];
            }
        }

        return dp[d - 1][n];
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        list = denoms;
        d = denoms.length;
        dp = new int[d + 1][n + 1];

// First solution
//        for (int i = 0; i < d + 1; i ++)
//            for (int ii = 0; ii < n + 1; ii ++)
//                dp[i][ii] = -1;
//
//        return topDownDP(0, n);

// Second solution
        return  bottomUpDP(n);
    }
}
