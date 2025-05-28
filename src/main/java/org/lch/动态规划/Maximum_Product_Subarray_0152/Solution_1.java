package org.lch.动态规划.Maximum_Product_Subarray_0152;

public class Solution_1 {

    // 暴力求解
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                cur *= nums[j];
                max = Math.max(max, cur);
            }
            cur = 1;
        }
        return max;
    }

}
