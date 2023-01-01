package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {

    public ArrayList<ArrayList<String>> semordnilap(String[] words) {

        Set < String > set = new HashSet<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i ++){

            String reversed = new StringBuilder(words[i]).reverse().toString();

            if (set.contains(reversed)){

                result.add(new ArrayList<>(Arrays.asList(words[i], reversed)));
            }

            set.add(words[i]);
        }

        return result;
    }
}
