package org.lch.动态规划.House_Robber_0198;

public class Solution_1 {

    // dp[i][0]：第i天偷的最大money
    // dp[i][1]：第i天不偷的最大money
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = 0;

        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            //  今天不偷 那么昨天也可偷也可以不偷
            dp[i][1] =  Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }

}
