package com.mumusta.algoexpert;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortedSquaredArray {

//    public static int[] sortedSquaredArray(int[] array) {
//
//        return Arrays
//                .stream(array)
//                .map(x -> x * x)
//                .sorted()
//                .toArray();
//    }


//  public static int[] sortedSquaredArray(int[] array) {
//
//        int n = array.length, right = n, left = -1;
//
//        for (int i = 0; i < n; i ++)
//            if (array[i] < 0)
//                left = i;
//
//        for (int i = 0; i < n; i ++)
//            if (array[i] >= 0) {
//                right = i;
//                break;
//            }
//
//        int[] result = new int[n]; int index = 0;
//
//        while (index < n){
//
//            if ((left < 0) || ((right < n) && (Math.abs(array[left]) > array[right]))){
//
//                result[index] = array[right] * array[right];
//                index ++; right ++;
//
//                continue;
//            }
//
//            if (right >= n || Math.abs(array[left]) <= array[right]){
//
//                result[index] = array[left] * array[left];
//                index ++; left --;
//            }
//        }
//
//        return result;
//  }


    public static int[] sortedSquaredArray(int[] array) {

        int n = array.length, right = n - 1, left = 0;
        int[] result = new int[n]; int index = n - 1;

        while (index >= 0){

            if (Math.abs(array[left]) > Math.abs(array[right])){

                result[index--] = array[left] * array[left]; left ++;
            }

            else {

                result[index--] = array[right] * array[right]; right --;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        //int[] answer = sortedSquaredArray(new int[] { -8, -2, 0, 5, 6, 8, 99 });
        int[] answer = sortedSquaredArray(new int[] { -8, -2, -1 });

        for (int i    = 0; i < answer.length; i ++) {

            System.out.println(answer[i]);
        }
    }
}
