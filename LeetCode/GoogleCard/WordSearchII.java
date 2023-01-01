package com.mumusta.googlecard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 22/08/2022
 *
 *
 **/

public class WordSearchII {

    private static int n, m;
    private static char[][] board;
    private static String[] words;
    private static boolean[][] vis;
    private static HashSet < String > result;
    private static HashSet < String > partial;
    private static HashSet < String > complete;


    private static void solve (int i, int ii, StringBuilder current){

        if ((i < 0) || (ii < 0) || (i >= n) || (ii >= m))
            return;

        if (vis[i][ii])
            return;

        String temp = current.toString() + board[i][ii];

        //System.out.println("temp = " + temp);

        if (complete.contains(temp)){

            result.add(temp);
        }

        if (!partial.contains(temp))
            return;

        vis[i][ii] = true;

        solve(i + 1, ii, new StringBuilder(temp));
        solve(i - 1, ii, new StringBuilder(temp));
        solve(i, ii + 1, new StringBuilder(temp));
        solve(i, ii - 1, new StringBuilder(temp));

        vis[i][ii] = false;
    }

    public static List<String> findWords(char[][] board_, String[] words_) {

        board = board_;
        words = words_;
        n = board_.length;
        m = board_[0].length;
        vis = new boolean[n][m];
        result = new HashSet<>();
        partial = new HashSet<>();
        complete = new HashSet<>();

        for (int i = 0; i < words.length; i ++){

            StringBuilder temp = new StringBuilder();
            partial.add(temp.toString());

            for (int ii = 0; ii < words[i].length(); ii ++){

                temp.append(words[i].charAt(ii));
                partial.add(temp.toString());
            }

            complete.add(temp.toString());
        }

        for (int i = 0; i < n; i ++)
            for (int ii = 0; ii < m; ii ++){

                //System.out.println("i = " + i);
                //System.out.println("ii = " + ii);
                solve(i, ii, new StringBuilder());
            }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

        System.out.println(findWords(new char[][] { { 'a' }, { 'a' } }, new String[] { "aaa" }));
        System.out.println(findWords(new char[][] { { 'a' } }, new String[] { "a" }));
        System.out.println(findWords(new char[][] { { 'o','a','a','n' }, { 'e','t','a','e' }, { 'i','h','k','r' }, { 'i','f','l','v'} }, new String[] { "oath","pea","eat","rain" }));
    }
}
