package com.mumusta.googlecard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 21/08/2022
 *
 * Classic stack example, took 15 Minutes to solve and implment.
 **/


public class ValidParentheses {

    public static boolean isValid(String s) {

        ArrayDeque < Character > stack = new ArrayDeque<>();
        HashMap< Character, Character > pair = new HashMap<>();

        pair.put('[', ']'); pair.put('{', '}'); pair.put('(', ')');

        for (int i = 0; i < s.length(); i ++){

            char c = s.charAt(i);

            if (pair.containsKey(c)){

                stack.offerFirst(c);
            }

            else {

                if (stack.isEmpty())
                    return false;

                if (!pair.containsKey(stack.peekFirst()))
                    return false;

                if (pair.get(stack.peekFirst()) == c){

                    stack.pollFirst();
                }

                else {

                    return  false;
                }
            }
        }

        if (!stack.isEmpty())
            return false;

        return true;
    }

    public static void main(String[] args) {

        System.out.println(isValid("(]"));
    }
}
