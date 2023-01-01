package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 17/08/2022
 *
 * 
 **/

public class NextClosestTime {

    private static String validString(int x){

        if (x > 9)
            return Integer.toString(x);

        return "0" + Integer.toString(x);
    }
    public static String nextClosestTime(String time) {

        String result = "";
        boolean isHours = true;
        int hours = 0, minutes = 0;
        boolean[] isValid = new boolean[10];

        for (int i = 0; i < time.length(); i ++){

            if (time.charAt(i) == ':'){

                isHours = false;
                continue;
            }

            if(isHours){

                hours *= 10;
                hours += time.charAt(i) - '0';
            }

            else {

                minutes *= 10;
                minutes += time.charAt(i) - '0';
            }

            isValid[time.charAt(i) - '0'] = true;
        }

        while (true){

            minutes++;

            if (minutes == 60){

                minutes = 0;

                hours++;

                if (hours == 24){

                    hours = 0;
                }
            }

            boolean ok = true;

            String temp = validString(minutes) + validString(hours);

            for (int i = 0; i < 4; i ++){

                ok &= (isValid[temp.charAt(i) - '0']);
            }

            if (ok){

                result = validString(hours) + ":" + validString(minutes);
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(nextClosestTime("23:59"));
    }
}
