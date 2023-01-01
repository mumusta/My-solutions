package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    private static int solve(List<Object> list, int depth){

        int result = 0;

        for (Object obj : list){

            if (obj instanceof ArrayList)
                result += solve((List<Object>)obj, depth + 1);

            else result += (Integer)obj;
        }

        return  result * depth;
    }

    public static int productSum(List<Object> array) {

        return solve(array, 1);
    }
}
