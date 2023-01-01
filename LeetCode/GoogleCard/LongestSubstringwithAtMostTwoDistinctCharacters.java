package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 17/08/2022
 **/

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        int[] charCount = new int[130];
        charCount[s.charAt(0)] = 1;
        int uniqueChar = 1, totalChar = 1, left = 0, right = 0, result = 1;

        while (true){

            if (uniqueChar > 2){

                if (left == s.length())
                    break;

                totalChar--;
                charCount[s.charAt(left)]--;

                if(charCount[s.charAt(left)] == 0){

                    uniqueChar--;
                }

                left++;
            }

            else {

                if (right == (s.length() - 1))
                    break;

                right++;
                totalChar++;
                charCount[s.charAt(right)]++;

                if (charCount[s.charAt(right)] == 1){

                    uniqueChar++;
                }

                if (uniqueChar <= 2){

                    result = Math.max(result, totalChar);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
