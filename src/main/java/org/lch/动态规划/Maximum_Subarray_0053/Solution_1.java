package org.lch.动态规划.Maximum_Subarray_0053;

public class Solution_1 {

    // [-2,1,-3,4,-1,2,1,-5,4]
    // dp[i] 为以 nums[i] 结尾的最大子数组和
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
