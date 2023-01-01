package com.mumusta.googlecard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 21/08/2022
 *
 * I sorted the intervals according to the starting in ascending order,
 * then we keep track of the endings of the occupied rooms (or the last used ending) in a min heap.
 *
 * Took 50 Minutes after some hints.
 **/

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {

        int n = intervals.length;
        Arrays.sort(intervals, (ints, t1) -> Integer.compare(ints[0], t1[0]));

        PriorityQueue < Integer > ends = new PriorityQueue<>();

        for (int i = 0; i < n; i ++){

            if (ends.isEmpty()){

                ends.offer(intervals[i][1]);
            }

            else {

                if (ends.peek() <= intervals[i][0]){

                    ends.poll();
                    ends.offer(intervals[i][1]);
                }

                else {

                    ends.offer(intervals[i][1]);
                }
            }
        }

        return  ends.size();
    }

    public static void main(String[] args) {

        System.out.println(minMeetingRooms(new int[][] { new int[]{13, 15}, new int[]{1, 13} }));
    }
}
