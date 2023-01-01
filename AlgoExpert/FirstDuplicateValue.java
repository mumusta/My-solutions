package com.mumusta.algoexpert;

public class FirstDuplicateValue {

    public int firstDuplicateValue(int[] array) {

        int n = array.length;

        for (int i = 0; i < n; i ++){

            int x = Math.abs(array[i]);

            if (array[x - 1] < 0)
                return x;

            else array[x - 1] *= -1;
        }

        return -1;
    }
}
