package com.mumusta.algoexpert;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length; i ++){

            int minima = array[i], who = i;

            for (int ii = i + 1; ii < array.length; ii ++){

                if (array[ii] < minima){

                    minima = array[ii];
                    who = ii;
                }
            }

            int first = array[i];
            array[i] = array[who];
            array[who] = first;
        }

        return array;
    }
}
