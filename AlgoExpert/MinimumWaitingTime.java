package com.mumusta.algoexpert;

import java.util.Arrays;

public class MinimumWaitingTime {

    public int minimumWaitingTime(int[] queries) {

        Arrays.sort(queries);
        int count = queries.length - 1, result = 0;

        for (int i = 0; i < queries.length; i ++)
            result += (count-- * queries[i]);

        return result;
    }
}
