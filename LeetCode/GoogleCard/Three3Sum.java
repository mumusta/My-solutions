package com.mumusta.googlecard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 13/08/2022
 *
 * Solve it before.
 *  Took 25 Minutes.
 **/

public class Three3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        HashMap < Integer, Integer > lastAppearance = new HashMap<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i ++){

            lastAppearance.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i ++){

            if ((i != 0) && (nums[i] == nums[i - 1]))
                continue;

            for (int j = i + 1; j < nums.length; j ++){

                if ((j != (i + 1)) && (nums[j] == nums[j - 1]))
                    continue;

                List< Integer > temp = new ArrayList<>();

                int k = - (nums[i] + nums[j]);

                if (lastAppearance.containsKey(k) && lastAppearance.get(k) > j){

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(k);
                }

                if (temp.size() > 0)
                    result.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(threeSum(new int[] { -1,0,1,2,-1,-4 }));
    }
}
