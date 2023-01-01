package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {

        List<Integer> result = new ArrayList<>();
        int rows = array.length, columns = array[0].length, i = 0, j = 0;

        while (rows != 0 && columns != 0){

            if (rows == 1){

                for (int x = j; x < (j + columns); x ++)
                    result.add(array[i][x]);

                break;
            }

            else if (columns == 1){

                for (int x = i; x < (i + rows); x ++)
                    result.add(array[x][j]);

                break;
            }

            else {

                int x;

                for (x = j; x < (j + columns - 1); x ++)
                    result.add(array[i][x]);

                j = x;

                for (x = i; x < (i + rows - 1); x ++)
                    result.add((array[x][j]));

                i = x;

                for (x = j; x > (j - columns + 1); x --)
                    result.add(array[i][x]);

                j = x;

                for (x = i; x > (i - rows + 1); x --)
                    result.add(array[x][j]);

                i = x;

                i++; j++;
                rows -= 2;
                columns -= 2;
            }
        }

        return result;
    }
}
