package com.mumusta.googlecard;

import java.util.Arrays;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 21/08/2022
 *
 *
 **/

public class FindAndReplaceInString {

    private static class Triple implements Comparable< Triple >{

        int indice;
        String source, target;

        public Triple(int indice, String source, String target) {
            this.indice = indice;
            this.source = source;
            this.target = target;
        }

        @Override
        public int compareTo(Triple triple) {
            return Integer.compare(indice, triple.indice);
        }
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n = indices.length;

        Triple[] all = new Triple[n];

        for (int i = 0; i < n; i ++){

            all[i] = new Triple(indices[i], sources[i], targets[i]);
        }

        Arrays.sort(all);

        for (int i = 0; i < n; i ++){

            indices[i] = all[i].indice;
            sources[i] = all[i].source;
            targets[i] = all[i].target;
        }

        boolean[] ok = new boolean[n];

        for (int i = 0; i < n; i ++){

            StringBuilder temp = new StringBuilder();

            for (int x = indices[i]; (x < s.length()) && (x < (indices[i] + sources[i].length())); x ++){

                temp.append(s.charAt(x));
            }

            ok[i] = temp.toString().equals(sources[i]);
        }

        int pointer = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i ++){

            if (!ok[i])
                continue;

            if (indices[i] > pointer){

                result.append(s.substring(pointer, indices[i]));
                pointer = indices[i];
            }

            result.append(targets[i]);
            pointer += sources[i].length();
        }

        if (pointer < s.length()){

            result.append(s.substring(pointer, s.length()));
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" }, new String[] { "eee", "ffff" }));
        System.out.println(findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" }, new String[] { "eee", "ffff" }));
        //Answer is "vbfrssozp"
        System.out.println(findReplaceString("vmokgggqzp", new int[] { 3, 5, 1 }, new String[] { "kg","ggq","mo" }, new String[] { "s","so","bfr" }));
    }
}
