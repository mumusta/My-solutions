package com.mumusta.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {

        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        boolean isRed = true, isBlue = true;

        for (int i = 0; i < redShirtHeights.size(); i ++){

            isRed &= redShirtHeights.get(i) > blueShirtHeights.get(i);
            isBlue &= redShirtHeights.get(i) < blueShirtHeights.get(i);
        }

        return isRed | isBlue;
    }
}
