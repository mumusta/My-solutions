package com.mumusta.googlecard;

import java.util.HashMap;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 13/08/2022
 *
 * So we are going to solve it using the 2 pointers technique
 * Took 40 minutes with simulating an interview
 **/

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty())
            return 0;

        HashMap < Character, Integer > characterCount = new HashMap<>();

        for (int i = 0; i < s.length(); i ++){

            characterCount.put(s.charAt(i), 0 );
        }

        int left = 0, right = 0, maximum = 1, uniqueCharacter = 0, totalCharacter = 0;

        totalCharacter++;
        uniqueCharacter++;
        characterCount.put(s.charAt(0), 1);

        while (true){

            if(uniqueCharacter == totalCharacter){

                if (right == (s.length() - 1))
                    break;

                right++;
                totalCharacter++;

                if(characterCount.get(s.charAt(right)) == 0){

                    uniqueCharacter++;
                }

                characterCount.put(s.charAt(right), characterCount.get(s.charAt(right)) + 1);

                if (uniqueCharacter == totalCharacter){

                    maximum = Math.max(maximum, totalCharacter);
                }
            }

            else {

                if (left == s.length())
                    break;

                totalCharacter--;

                if (characterCount.get(s.charAt(left)) == 1){

                    uniqueCharacter--;
                }

                characterCount.put(s.charAt(left), characterCount.get(s.charAt(left)) - 1);

                left++;
            }
        }

        return maximum;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring(""));
    }
}
