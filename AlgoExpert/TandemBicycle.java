package com.mumusta.algoexpert;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycle {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        int result = 0;

        if (fastest){

            for (int i = 0, ii = (blueShirtSpeeds.length - 1); i < redShirtSpeeds.length; i ++, ii --)
                result += Math.max(redShirtSpeeds[i], blueShirtSpeeds[ii]);
        }

        else {

            for (int i = 0; i < redShirtSpeeds.length; i ++)
                result += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }

        return result;
    }
}
