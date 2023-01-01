package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 10/08/2022
 *
 *
 *
 **/


public class OddEvenJump {

    private static int n;
    private static int[][] dp;
    private static int [] evenMove, oddMove;

    private static int solve (int current, int jumps){

        if (current == (n - 1)) return 1;

        if (dp[current][jumps] != -1) return dp[current][jumps];

        dp[current][jumps] = 0;

        if (jumps % 2 == 0){

            if (evenMove[current] != current){

                dp[current][jumps] = Math.max(dp[current][jumps], solve(evenMove[current], (jumps + 1) % 2));
            }
        }

        else {

            if (oddMove[current] != current){

                dp[current][jumps] = Math.max(dp[current][jumps], solve(oddMove[current], (jumps + 1) % 2));
            }
        }

        return dp[current][jumps];
    }

    public static int oddEvenJumps(int[] arr) {

        n = arr.length;
        evenMove = new int[n]; oddMove = new int[n];
        dp = new int[n][2];

        for (int i = 0; i < n; i ++){

            int smallestGreaterOrEqual = Integer.MAX_VALUE, whoOdd = i;
            int largestSmallerOrEuqal = Integer.MIN_VALUE, whoEven = i;

            for (int j = i + 1; j < n; j ++){

                if (arr[i] <= arr[j]){

                    if (arr[j] < smallestGreaterOrEqual){

                        whoOdd = j;
                        smallestGreaterOrEqual = arr[j];
                    }
                }

                if (arr[i] >= arr[j]){

                    if (arr[j] > largestSmallerOrEuqal){

                        whoEven = j;
                        largestSmallerOrEuqal = arr[j];
                    }
                }
            }

            evenMove[i] = whoEven;
            oddMove[i] = whoOdd;
        }

        int result = 0;

        for (int i = 0; i < n; i ++){

            for (int ii = 0; ii < 2; ii ++){

                dp[i][ii] = -1;
            }
        }

        for (int i = 0; i < n; i ++){

            result += solve(i, 1);
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(oddEvenJumps(new int[]{ 10,13,12,14,15 }));
    }
}
