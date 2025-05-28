package org.lch.动态规划.Perfect_Squares_0279;

import java.util.Arrays;

public class Solution_1 {

    // dp[i]表示组成整数 i 所需的最少完全平方数的个数。
    // 通过遍历 j * j <= i
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}
