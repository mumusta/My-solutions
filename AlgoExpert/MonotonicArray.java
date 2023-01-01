package com.mumusta.algoexpert;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {

        int n = array.length;

        if (n == 0 || n == 1)
            return true;

        boolean nonDecreasing = true, nonIncreasing = true;

        for (int i = 0; i < (n - 1); i ++){

            nonDecreasing &= (array[i] <= array[i + 1]);
            nonIncreasing &= (array[i] >= array[i + 1]);
        }

        return nonDecreasing | nonIncreasing;
    }
}
