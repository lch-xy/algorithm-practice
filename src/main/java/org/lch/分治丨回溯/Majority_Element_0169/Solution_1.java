package org.lch.分治丨回溯.Majority_Element_0169;

import java.util.Arrays;

public class Solution_1 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length /2];
    }

}
