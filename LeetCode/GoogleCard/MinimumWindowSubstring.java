package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 17/08/2022
 *
 * 2 pointers, took 30 Minutes to solve and implement
 **/

public class MinimumWindowSubstring {

    private static boolean isVaild(int[] a, int[] b){

        boolean result = true;

        for (int i = 0; i < a.length; i ++){

            result &= (a[i] <= b[i]);
        }

        return result;
    }

    public static String minWindow(String s, String t) {

        int[] tCount = new int[130], sCount = new int[130];
        int S = s.length(), T = t.length(), result = Integer.MAX_VALUE, leftResult = 0, rightResult = 0;

        for (int i = 0; i < T; i ++){

            tCount[t.charAt(i)]++;
        }

        int left = 0, right = 0;

        sCount[s.charAt(0)]++;

        while (true){

            if (!isVaild(tCount, sCount)){

                if (right == (S - 1))
                    break;

                right++;
                sCount[s.charAt(right)]++;
            }

            else {

                if ((right - left + 1) < result){

                    leftResult = left;
                    rightResult = right;
                    result = (right - left + 1);
                }

                if (left == S)
                    break;

                sCount[s.charAt(left)]--;
                left++;
            }
        }

        if (result != Integer.MAX_VALUE)
            return s.substring(leftResult, rightResult + 1);

        return "";
    }

    public static void main(String[] args) {

        System.out.println(minWindow("a", "aa"));
    }
}
