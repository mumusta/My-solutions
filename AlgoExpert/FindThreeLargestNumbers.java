package com.mumusta.algoexpert;

import java.util.Arrays;

public class FindThreeLargestNumbers {

    public static int[] findThreeLargestNumbers(int[] array) {

        int[] result = new int[3];

        for (int i = 0; i < 3; i ++)
            result[i] = array[i];

        Arrays.sort(result);

        for (int i = 3; i < array.length; i ++){

            if (array[i] >= result[2]){

                result[0] = result[1];
                result[1] = result[2];
                result[2] = array[i];
            }

            else if (array[i] < result[2]){

                if (array[i] >= result[1]){

                    result[0] = result[1];
                    result[1] = array[i];
                }

                else if (array[i] < result[1]){

                    if (array[i] >= result[0])
                        result[0] = array[i];
                }
            }
        }

        return result;
    }
}
