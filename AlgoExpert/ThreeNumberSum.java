package com.mumusta.algoexpert;

import java.util.*;

public class ThreeNumberSum {

//    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
//
//        Arrays.sort(array);
//
//        List<Integer[]> result = new ArrayList<>();
//        Map < Integer, Integer > map = new HashMap<>();
//
//        for (int i = 0; i < array.length; i ++)
//            map.put(array[i], i);
//
//        for (int i = 0; i < array.length; i ++){
//
//            for (int ii = i + 1; ii < array.length; ii ++){
//
//                int a = array[i], b = array[ii], c = targetSum - (a + b);
//
//                if (map.getOrDefault(c, -1) > ii){
//
//                    result.add(new Integer[] { a, b, c });
//                }
//            }
//        }
//
//        return result;
//    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < (array.length - 2); i ++){

            int a = array[i], l = i + 1, r = (array.length - 1);

            while (l < r){

                int b = array[l], c = array[r];

                if ((a + b + c) < targetSum) l ++;

                else if ((a + b + c) > targetSum) r --;

                else {

                    result.add(new Integer[] { a, b, c });
                    l ++; r --;
                }
            }
        }

        return result;
    }
}
