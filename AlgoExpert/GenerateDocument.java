package com.mumusta.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public boolean generateDocument(String characters, String document) {

        Map< Character, Integer > c = new HashMap<>(), d = new HashMap<>();

        for (int i = 0; i < characters.length(); i ++)
            c.put(characters.charAt(i), c.getOrDefault(characters.charAt(i), 0) + 1);

        for (int i = 0; i < document.length(); i ++)
            d.put(document.charAt(i), d.getOrDefault(document.charAt(i), 0) + 1);

        boolean result = true;

        for (int i = 0; i < document.length(); i ++)
            result &= (c.getOrDefault(document.charAt(i), 0) >= d.get(document.charAt(i)));

        return result;
    }
}
