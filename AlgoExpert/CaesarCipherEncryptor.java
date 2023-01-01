package com.mumusta.algoexpert;

public class CaesarCipherEncryptor {

    public static String caesarCypherEncryptor(String str, int key) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i ++)
            sb.append((char)(((((int)str.charAt(i) - (int)'a') + key) % 26) + (int)'a'));

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(caesarCypherEncryptor("xyz", 2));
    }
}
