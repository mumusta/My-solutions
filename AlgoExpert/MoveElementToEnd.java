package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int left = 0, right = 0, n = array.size();

        while (true){

            while (left < n && array.get(left) != toMove)
                left ++;

            if (left >= n) break;

            if (right < left)
                right = left + 1;

            while (right < n && array.get(right) == toMove)
                right ++;

            if (right >= n) break;

            array.set(left, array.get(right));
            array.set(right, toMove);
        }

        return array;
    }

    public static void main(String[] args) {

        System.out.println(moveElementToEnd(Arrays.asList(1, 2, 9, 3, 9, 9, 9, 9, 4, 9, 5), 9));
    }
}
