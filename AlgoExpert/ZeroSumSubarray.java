package com.mumusta.algoexpert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Zero Sum Subarray
public class ZeroSumSubarray {

    public boolean zeroSumSubarray(int[] nums) {

        int n = nums.length, total = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);

        for (int i = 0; i < n; i ++){

            if (nums[i] == 0) return true;

            else {

                total += nums[i];

                if (set.contains(total))
                    return true;

                else {

                    set.add(total);
                }
            }
        }

        return false;
    }
}
