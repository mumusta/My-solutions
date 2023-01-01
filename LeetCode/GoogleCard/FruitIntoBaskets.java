package com.mumusta.googlecard;

import java.util.HashMap;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 10/08/2022
 *
 * The problem is a two pointers problem, after optimizing from the brute force of two, we can make a 2n iterations.
 *
 * Took 40 Minutes to solve from the second try.
 **/


public class FruitIntoBaskets {

    public static int totalFruit(int[] seq) {

        if (seq.length < 3)
            return seq.length;

        HashMap<Integer, Integer> fruit = new HashMap<>();
        int totalNumberFruits = 0, categories = 0, left = -1, right = -1, maximum = Integer.MIN_VALUE;

        for (int i = 0; i < seq.length; i ++)
            fruit.put(seq[i], 0);

        while (true){

            if (right == (seq.length - 1))
                break;

            if (categories > 2){

                left ++;

                totalNumberFruits--;
                fruit.put(seq[left], fruit.get(seq[left]) - 1);

                if (fruit.get(seq[left]) == 0){

                    categories--;
                }
            }

            else {

                right ++;

                totalNumberFruits++;
                fruit.put(seq[right], fruit.get(seq[right]) + 1);

                if (fruit.get(seq[right]) == 1){

                    categories++;
                }

                if (categories <= 2){

                    maximum = Math.max(maximum, totalNumberFruits);
                }
            }
        }

        return maximum;
    }

    public static void main(String[] args) {

        System.out.println(totalFruit(new int[] { 0, 1, 2, 2 }));
    }
}
