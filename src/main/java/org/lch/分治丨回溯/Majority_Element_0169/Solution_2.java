package org.lch.分治丨回溯.Majority_Element_0169;

import java.util.Arrays;

public class Solution_2 {

    // Boyer-Moore 投票算法
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

}
