package com.mumusta.algoexpert;

public class BinarySearch {

//    private static int solveRec(int[] array, int target, int start, int end){
//
//        if (start > end)
//            return  -1;
//
//        int mid = (start + end) / 2;
//
//        if (array[mid] == target)
//            return  mid;
//
//        if (array[mid] < target)
//            return solveRec(array, target, mid + 1, end);
//
//        else return solveRec(array, target, start, mid - 1);
//    }

    private static int solve(int[] array, int target, int start, int end){

        while (start <= end){

            int mid = (start + end) / 2;

            if (array[mid] == target)
                return  mid;

            if (array[mid] < target)
                start = mid + 1;

            else end = mid - 1;
        }

        return -1;
    }

    public static int binarySearch(int[] array, int target) {

        return solve(array, target, 0, array.length - 1);
    }
}
