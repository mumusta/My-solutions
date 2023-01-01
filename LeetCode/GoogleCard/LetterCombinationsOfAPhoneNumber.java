package com.mumusta.googlecard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 22/08/2022
 *
 * Recursive brute force, generate all the possibilities.
 * Took 20 minutes to solve and implement.
 **/


public class LetterCombinationsOfAPhoneNumber {

    private static int n;
    private static String digits;
    private static List < String > result;
    private static HashMap < Character, List < Character > > map;

    static {

        map = new HashMap<>();

        List < Character > temp = new ArrayList<>();
        temp.add('a'); temp.add('b'); temp.add('c');
        map.put('2', temp);

        temp = new ArrayList<>();
        temp.add('d'); temp.add('e'); temp.add('f');
        map.put('3', temp);

        temp = new ArrayList<>();
        temp.add('g'); temp.add('h'); temp.add('i');
        map.put('4', temp);

        temp = new ArrayList<>();
        temp.add('j'); temp.add('k'); temp.add('l');
        map.put('5', temp);

        temp = new ArrayList<>();
        temp.add('m'); temp.add('n'); temp.add('o');
        map.put('6', temp);

        temp = new ArrayList<>();
        temp.add('p'); temp.add('q'); temp.add('r'); temp.add('s');
        map.put('7', temp);

        temp = new ArrayList<>();
        temp.add('t'); temp.add('u'); temp.add('v');
        map.put('8', temp);

        temp = new ArrayList<>();
        temp.add('w'); temp.add('x'); temp.add('y'); temp.add('z');
        map.put('9', temp);
    }

    private static void solve (int i, StringBuilder curr){

        if (i == n){

            result.add(curr.toString());
            return;
        }

        List < Character > possibilities = map.get(digits.charAt(i));
        for (int x = 0; x < possibilities.size(); x ++){

            solve(i + 1, new StringBuilder(curr.toString() + possibilities.get(x)));
        }
    }

    public static List<String> letterCombinations(String digits_) {

        if (digits_.length() == 0)
            return  new ArrayList<>();

        digits = digits_;
        n = digits_.length();

        result = new ArrayList<>();

        solve(0, new StringBuilder());

        return result;
    }

    public static void main(String[] args) {

        System.out.println();
    }
}
