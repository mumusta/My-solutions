package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TournamentWinner {

    /*
        public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        String result = "";
        int n = results.size(), maxima = -1;
        Map < String, Integer > map = new HashMap<>();

        for (int i = 0; i < n; i ++){

            String home = competitions.get(i).get(0), away = competitions.get(i).get(1);

            if (results.get(i) == 1){

                map.put(home, map.getOrDefault(home, 0) + 3);

                if (map.getOrDefault(home, 0) > maxima){

                    maxima = map.getOrDefault(home, 0);
                    result = home;
                }
            }

            if (results.get(i) == 0) {

                map.put(away, map.getOrDefault(away, 0) + 3);

                if (map.getOrDefault(away, 0) > maxima){

                    maxima = map.getOrDefault(away, 0);
                    result = away;
                }
            }
        }

        return result;
    }
    */

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        int n = results.size();
        Map < String, Integer > map = new HashMap<>();

        for (int i = 0; i < n; i ++){

            String home = competitions.get(i).get(0), away = competitions.get(i).get(1);

            if (results.get(i) == 1){

                if (!map.containsKey(home))
                    map.put(home, 0);

                map.computeIfPresent(home, (k, v) -> v + 3);
            }

            if (results.get(i) == 0) {

                if (!map.containsKey(away))
                    map.put(away, 0);

                map.computeIfPresent(away, (k, v) -> v + 3);
            }
        }

        return map
                .entrySet()
                .stream()
                .max((stringIntegerEntry, t1) -> stringIntegerEntry.getValue() - t1.getValue())
                .get()
                .getKey();
    }

    public static void main(String[] args) {

        //
    }
}
