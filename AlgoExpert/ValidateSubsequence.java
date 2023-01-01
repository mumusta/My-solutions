package com.mumusta.algoexpert;

import java.util.List;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        int index = 0;

        for (int i = 0; (i < array.size()) && (index < sequence.size()); i ++){

            if (array.get(i) == sequence.get(index))
                index++;
        }

        return index == sequence.size();
    }
}
