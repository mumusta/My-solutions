package com.mumusta.algoexpert;

public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {

        int n = array.length;
        int[] left = new int[n], right = new int[n], result = new int[n];

        left[0] = array[0]; right[n - 1] = array[n - 1];

        for (int i = 1; i < n; i ++)
            left[i] = array[i] * left[i - 1];

        for (int i = (n - 2); i >= 0; i --)
            right[i] = array[i] * right[i + 1];

        result[0] = right[1]; result[n - 1] = left[n - 2];

        for (int i = 1; i < n - 1; i ++)
            result[i] = left[i - 1] * right[i + 1];

        return result;
    }
}
