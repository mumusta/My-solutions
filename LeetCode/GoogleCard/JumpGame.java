package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 13/08/2022
 **/


public class JumpGame {

    private static int n;
    private static int[] seq;
    private static boolean[] vis;
    private static boolean isAble;

    private static void solve(int x){

        if (x >= n) return;

        if (x == (n - 1)){

            isAble = true;
            return;
        }

        if (vis[x]) return;

        if (isAble) return;

        vis[x] = true;

        for (int i = 1; (i <= seq[x]) && ((x + i) < n); i ++){

            solve(x + i);
        }

        return;
    }

    public static boolean canJump(int[] nums) {

        seq = nums;
        isAble = false;
        n = nums.length;
        vis = new boolean[n];

        solve(0);

        return isAble;
    }

    public static void main(String[] args) {

        System.out.println(canJump(new int[]{ 3,2,1,0,4 }));
    }
}
