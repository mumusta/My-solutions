package com.mumusta.algoexpert;

//Best Seat
public class BestSeat {

    public int bestSeat(int[] seats) {

        int n = seats.length;

        if (n == 1){

            if (seats[0] == 0)
                return  0;

            else return  -1;
        }

        int[] left = new int[n],
                right = new int[n];

        left[0] = 0; right[n - 1] = n - 1;

        for (int i = 1; i < n; i ++){

            left[i] = left[i - 1];

            if (seats[i] == 1){

                left[i] = i;
            }
        }

        for (int i = (n - 2); i >= 0; i --){

            right[i] = right[i + 1];

            if (seats[i] == 1){

                right[i] = i;
            }
        }

        int maximum = -1000_000, index = -1;

        for (int i = 0; i < n; i ++){

            if (seats[i] == 1)
                continue;

            int current = (i - left[i]) + (right[i] - i);

            if ((Math.abs((i - left[i]) - (right[i] - i)) <= 1) && (current > maximum)){

                maximum = current;
                index = i;
            }
        }

        return index;
    }
}
