package org.lch.动态规划.Maximum_Product_Subarray_0152;

public class Solution_2 {

    // 每次存一下当前的最大最小值
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(temp * nums[i], curMin * nums[i]));
            max = Math.max(max, curMax);
        }

        return max;
    }

}
