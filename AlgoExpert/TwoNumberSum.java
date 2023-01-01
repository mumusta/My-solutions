package com.mumusta.algoexpert;

import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {

        int[] result = new int[2];
        Set < Integer > set = new HashSet<>();

        for (int i = 0; i < array.length; i ++){

            set.add(array[i]);
        }

        for (int i = 0; i < array.length; i ++){

            if (set.contains(targetSum - array[i]) && ((targetSum - array[i]) != array[i])){

                result[0] = array[i];
                result[1] = targetSum - array[i];

                return result;
            }
        }

        return new int[0];
    }
}
