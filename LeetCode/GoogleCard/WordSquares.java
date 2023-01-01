package com.mumusta.googlecard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 22/08/2022
 *
 * Hard recursion, took me 2 hours to solve an implement.
 **/

public class WordSquares {

    private static int numColumns;
    private static List<List<String>> result;
    private static HashMap < String, List < Integer > > positions;
    private static String[] words;


    private static List < String > getStrings(List < Integer > list){

        List < String > res = new ArrayList<>();

        for (int i = 0 ; i < list.size(); i ++)
            res.add(words[list.get(i)]);

        return res;
    }
    private static String verticalString(List < Integer > list){

        StringBuilder temp = new StringBuilder();
        List < String > grid = getStrings(list);

        for (int i = 0; i < list.size(); i ++){

            temp.append(grid.get(i).charAt(list.size()));
        }

        //System.out.println("temp = " + temp);

        return  temp.toString();
    }

    private static void solve (List < Integer > words){

        System.out.println("getStrings(words) = " + getStrings(words));

        if (words.size() == numColumns){

            result.add(getStrings(words));
            return;
        }

        String prefix = verticalString(words);

        System.out.println("prefix = " + prefix);

        if (!positions.containsKey(prefix))
            return;

        List < Integer > possibleStrings = positions.get(prefix);

        //System.out.println("words = " + words);
        //System.out.println("possibleStrings = " + possibleStrings);

        for (int i = 0; i < possibleStrings.size(); i ++){

            List < Integer > temp = new ArrayList<>(words);
            temp.add(possibleStrings.get(i));

            solve(temp);
        }
    }

    public static List<List<String>> wordSquares(String[] words_) {

        words = words_;
        numColumns = words[0].length();
        result = new ArrayList<>();
        positions = new HashMap<>();

        for (int i = 0; i < words.length; i ++){

            StringBuilder temp = new StringBuilder();

            if (!positions.containsKey(temp.toString()))
                positions.put(temp.toString(), new ArrayList<>());

            List < Integer > listRef = positions.get(temp.toString());
            listRef.add(i);

            for (int ii = 0; ii < words[i].length(); ii ++){

                temp.append(words[i].charAt(ii));

                if (!positions.containsKey(temp.toString()))
                    positions.put(temp.toString(), new ArrayList<>());

                listRef = positions.get(temp.toString());
                listRef.add(i);
            }
        }

        solve(new ArrayList<>());

        return result;
    }

    public static void main(String[] args) {

        wordSquares(new String[] { "area","lead","wall","lady","ball" });
    }
}
