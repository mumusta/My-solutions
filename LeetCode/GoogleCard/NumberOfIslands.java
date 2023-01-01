package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 29/08/2022
 **/

public class NumberOfIslands {

    private static boolean[][] vis;
    private static int rows, columns, result;

    private static void dfs(int x, int y, char[][] grid){

        if (x < 0 || y < 0 || x >= rows || y >= columns)
            return;

        if (vis[x][y] || grid[x][y] == '0')
            return;

        vis[x][y] = true;

        dfs(x + 1, y, grid);
        dfs(x - 1, y, grid);
        dfs(x, y + 1, grid);
        dfs(x, y - 1, grid);
    }

    public int numIslands(char[][] grid) {

        result = 0;
        rows = grid.length;
        columns = grid[0].length;
        vis = new boolean[rows][columns];

        for (int i = 0; i < rows; i ++){

            for (int ii = 0; ii < columns; ii ++){

                if (!vis[i][ii] && grid[i][ii] == '1'){

                    result++;
                    dfs(i, ii, grid);
                }
            }
        }

        return result;
    }
}
