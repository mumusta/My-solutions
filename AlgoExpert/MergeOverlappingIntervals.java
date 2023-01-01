package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeOverlappingIntervals {

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        int n = intervals.length;
        ArrayList < ArrayList < Integer > > res = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < n; i ++){

            int x = intervals[i][0], y = intervals[i][1];

            if (end < x){

                res.add(new ArrayList<>(Arrays.asList(start, end)));
                start = x; end = y;
            }

            else {

                if (end < y){

                    end = y;
                }
            }
        }

        res.add(new ArrayList<>(Arrays.asList(start, end)));

        int[][] result = new int[res.size()][2];

        for (int i = 0; i < res.size(); i ++){

            result[i][0] = res.get(i).get(0);
            result[i][1] = res.get(i).get(1);
        }

        return result;
    }

    public static void main(String[] args) {

//        int[][] ints = mergeOverlappingIntervals(new int[][]{{1, 2}, {9, 10}, {3, 5}, {4, 7}, {6, 8}});
        int[][] ints = mergeOverlappingIntervals(new int[][]{{9, 99}, {9, 99}, {1, 2}, {2, 3}});

        for (int i = 0; i < ints.length; i ++){

            System.out.println(ints[i][0] + " " + ints[i][1]);
        }
    }
}
