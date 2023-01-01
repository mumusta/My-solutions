package com.mumusta.algoexpert;

public class NthFibonacci {

    private static final int MAX_IN = 500;
    private static int[] fib = new int[MAX_IN];

    static {
        fib[0] = 0; fib[1] = 1;
        for (int i = 2; i < MAX_IN; i ++)
            fib[i] = fib[i - 1] + fib[i - 2];
    }

    public static int getNthFib(int n) {
        return fib[n - 1];
    }

    public static void main(String[] args) {

        for (int i = 0 ; i < 20; i ++)
            System.out.println(getNthFib(i));

        System.out.println(getNthFib(6));
    }
}
