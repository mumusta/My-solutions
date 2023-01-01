package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 21/08/2022
 *
 * I took the left maximum and right maximum for each, and took the minimum of them,
 * if it is greater than the height we take the difference and this is the block of water that we will lift on that point.
 *
 * The problem took 30 Minutes to solve and implement (I solve it before).
 **/

public class TrappingRainWater {

    public static int trap(int[] height) {

        int maximum = 0, n = height.length;
        int [] canLift = new int[n];

        for (int i = 0; i < n; i ++){

            canLift[i] = maximum;

            if (height[i] > maximum){

                maximum = height[i];
            }
        }

        maximum = 0;

        for (int i = n - 1; i >= 0 ; i --){

            canLift[i] = Math.min(canLift[i], maximum);

            if (height[i] > maximum){

                maximum = height[i];
            }
        }

        int result = 0;

        for (int i = 0; i < n; i ++){

            if (canLift[i] > height[i]){

                result += (canLift[i] - height[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(trap(new int[] { 4,2,0,3,2,5 }));
    }
}
