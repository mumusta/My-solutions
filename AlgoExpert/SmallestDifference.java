package com.mumusta.algoexpert;

import java.util.Arrays;

public class SmallestDifference {

//    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
//
//        Arrays.sort(arrayTwo);
//
//        int[] result = new int[2];
//        int minima = Integer.MAX_VALUE;
//
//        for (int i = 0; i < arrayOne.length; i ++){
//
//            int target = arrayOne[i], start = 0, end = arrayTwo.length - 1;
//
//            while ((end - start) > 5){
//
//                int mid = (end - start) / 2;
//
//                if (target < arrayTwo[mid])
//                    end = mid - 1;
//
//                else if (target > arrayTwo[mid])
//                    start = mid + 1;
//
//                else {
//
//                    result[0] = target;
//                    result[1] = arrayTwo[mid];
//                    return result;
//                }
//            }
//
//            for (int mid = start; mid <= end; mid ++){
//
//                if (Math.abs(target - arrayTwo[mid]) < minima){
//
//                    minima = Math.abs(target - arrayTwo[mid]);
//                    result[0] = target;
//                    result[1] = arrayTwo[mid];
//                }
//            }
//        }
//        System.out.println("Tell the end ...");
//        return result;
//    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        int[] result = new int[2];
        int minima = Integer.MAX_VALUE;

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0, ii = 0, n = arrayOne.length, m = arrayTwo.length;

        while (i < n && ii < m){

            int a = arrayOne[i], b = arrayTwo[ii];

            if (Math.abs(a - b) < minima){

                minima = Math.abs(a - b);
                result[0] = a;
                result[1] = b;
            }

            if (a < b) i ++;

            else if (a > b) ii ++;

            else {

                result[0] = a;
                result[1] = b;
                return result;
            }
        }

        return result;
    }
}
