package com.mumusta.algoexpert;

public class LongestPeak {

//    public static int longestPeak(int[] array) {
//
//        if (array.length < 3)
//            return 0;
//
//        int n = array.length, maxima = 0;
//        int[] left = new int[n], right = new int[n];
//        left[0] = right[n - 1] = 1;
//
//        for (int i = 1; i < n; i ++){
//
//            if (array[i] > array[i - 1])
//                left[i] = 1 + left[i - 1];
//
//            else left[i] = 1;
//        }
//
//        for (int i = (n - 2); i >= 0; i --){
//
//            if (array[i] > array[i + 1])
//                right[i] = 1 + right[i + 1];
//
//            else right[i] = 1;
//        }
//
//        for (int i = 0; i < n; i ++){
//
//            int x = left[i] + right[i] - 1;
//
//            if (x >= 3 && left[i] > 1 && right[i] > 1){
//
//                maxima = Math.max(maxima, x);
//            }
//        }
//
//        return maxima;
//    }

    public static int longestPeak(int[] array) {

        int n = array.length, maxima = 0;

        if (n < 3) return  0;

        for (int i = 1; i < (n - 1); i ++){

            if (array[i - 1] < array[i] && array[i] > array[i + 1]){

                int left = 0, right = 0;

                for (int x = (i - 1); x >= 0; x --){

                    if (array[x] < array[x + 1])
                        left ++;

                    else break;
                }

                for (int x = i + 1; x < n; x ++){

                    if (array[x - 1] > array[x])
                        right ++;

                    else break;
                }

                maxima = Math.max(maxima, left + right + 1);

                i += right;
            }
        }

        return maxima;
    }
}
