package com.mumusta.algoexpert;

//Min Number Of Coins For Change
public class MinNumberOfCoinsForChange {

    private static int d;
    private static int[] list;
    private static int[][] dp;

    //First solution
    private static int topDownDP(int i, int remainder){

        if (i == d){

            if (remainder == 0) return 0;
            else return 1_000_000;
        }

        if (dp[i][remainder] != -1) return dp[i][remainder];

        dp[i][remainder] = topDownDP(i + 1, remainder);

        if (remainder >= list[i])
            dp[i][remainder] = Math.min(dp[i][remainder], 1 + topDownDP(i, remainder - list[i]));

        return  dp[i][remainder];
    }

    //Second solution
    private static int bottomUpDP(int n){

        for (int i = 0; i < d; i ++){

            int currentCoin = list[i];

            for (int remainder = 1; remainder <= n; remainder ++){

                dp[i][remainder] = 1_000_000;

                if (i > 0)
                    dp[i][remainder] = Math.min(dp[i][remainder], dp[i - 1][remainder]);

                if (remainder >= currentCoin)
                    dp[i][remainder] = Math.min(dp[i][remainder], 1 + dp[i][remainder - currentCoin]);
            }
        }

        if (dp[d - 1][n] >= 1_000_000)
            return -1;
        else return dp[d - 1][n];
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {

        list = denoms;
        d = denoms.length;
        dp = new int[d + 1][n + 1];

 //First solution
//        for (int i = 0; i < d + 1; i ++)
//            for (int ii = 0; ii < n + 1; ii ++)
//                dp[i][ii] = -1;
//        int answer = topDownDP(0, n);
//        if (answer >= 1_000_000)
//            return -1;
//        else return answer;

        //Second Solution
        return  bottomUpDP(n);
    }
}
