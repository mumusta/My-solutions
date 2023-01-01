package com.mumusta.algoexpert;

import java.util.Arrays;

public class InsertionSort {

    public static int[] insertionSort(int[] array) {

        for (int i = 1; i < array.length; i ++){

            int current = array[i];

            int j = i - 1;

            for (; j >= 0; j --){

                if (array[j] > current){

                    array[j + 1] = array[j];
                    array[j] = current;
                }

                else break;
            }
        }

        return array;
    }

    public static void main(String[] args) {

        Arrays.stream(insertionSort(new int[] {8, 5, 2, 9, 5, 6, 3}))
                .forEach(i -> System.out.print(i + " "));
    }
}
