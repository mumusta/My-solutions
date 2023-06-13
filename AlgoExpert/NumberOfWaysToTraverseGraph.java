package com.mumusta.algoexpert;

//Number Of Ways To Traverse Graph
public class NumberOfWaysToTraverseGraph {

    public int numberOfWaysToTraverseGraph(int width, int height) {

        int dp[][] = new int[height + 1][width + 1];

        dp[height][width] = 1;

        for (int i = height; i >= 1; i --){
            for (int ii = width; ii >= 1; ii --){

                if (ii != width)
                    dp[i][ii] += dp[i][ii + 1];

                if (i != height)
                    dp[i][ii] += dp[i + 1][ii];
            }
        }

        return dp[1][1];
    }
}
