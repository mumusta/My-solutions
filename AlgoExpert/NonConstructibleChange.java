package com.mumusta.algoexpert;

import java.util.Arrays;

public class NonConstructibleChange {

    public int nonConstructibleChange(int[] coins) {

        Arrays.sort(coins);

        int k = 0;

        for (int i = 0; i < coins.length; i ++){

            if (coins[i] > k + 1)
                break;

            k += coins[i];
        }

        return k + 1;
    }
}
