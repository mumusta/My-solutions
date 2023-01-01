package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 10/08/2022
 *
 * We just divide the string into k partitions and the reminder will be in the beginning (mod).
 *
 * It took 15 Minutes to solve from the first try.
 **/


public class LicenseKeyFormatting {

    public static String licenseKeyFormatting(String s, int k) {

        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < s.length(); i ++){

            if (s.charAt(i) == '-'){
                continue;
            }

            newString.append(Character.toUpperCase(s.charAt(i)));
        }

        s = newString.toString();
        StringBuilder result = new StringBuilder();

        int pointer = 0;

        for (; pointer < (s.length() % k); pointer++){

            result.append(s.charAt(pointer));
        }

        for (int i = 0; i < (s.length() / k); i ++){

            StringBuilder temp = new StringBuilder();

            for (int x = 0; x < k; x ++, pointer ++){

                temp.append(s.charAt(pointer));
            }

            if (result.length() > 0){

                result.append('-');
            }

            result.append(temp.toString());
        }

        return  result.toString();
    }

    public static void main(String[] args) {

        System.out.println(licenseKeyFormatting("2-5g-3-J", 3));
    }
}
