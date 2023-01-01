package com.mumusta.algoexpert;

public class PalindromeCheck {


    public static boolean isPalindrome(String str) {

        return solve(str, 0, str.length() - 1);
    }

    public static boolean solve(String str, int left, int right){

        if (left > right) return  true;
        return (str.charAt(left) == str.charAt(right)) && solve(str, left + 1, right - 1);
    }

    //    public static boolean isPalindrome(String str) {
//
//        boolean answer = true;
//        int left = 0, right = str.length() - 1;
//
//        while (left <= right)
//            answer &= (str.charAt(left ++) == str.charAt(right --));
//
//        return answer;
//    }
}
