package com.mumusta.algoexpert;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {

        int sortedCount = 0;
        boolean isSorted = false;

        while (!isSorted){

            isSorted = true;

            for (int i = 0; i < (array.length - (1 + sortedCount)); i ++){

                if (array[i] > array[i + 1]){

                    isSorted = false;

                    int first = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = first;
                }
            }

            sortedCount ++;
        }

        return array;
    }
}
