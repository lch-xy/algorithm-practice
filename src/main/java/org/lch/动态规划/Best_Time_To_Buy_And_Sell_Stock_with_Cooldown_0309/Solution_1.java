package org.lch.动态规划.Best_Time_To_Buy_And_Sell_Stock_with_Cooldown_0309;

public class Solution_1 {

    // dp[i][0]:表示第 i 天卖出股票的最大利润。
    // dp[i][1]:表示第 i 天持有股票的最大利润。
    // dp[i][2]:表示第 i 天休息的最大利润。
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            // 前一天卖出去了今天不动，前一天持有今天卖出去了
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            // 前一天冷却今天买入，前一天持有今天不动
            dp[i][1] = Math.max(dp[i-1][2] -prices[i],dp[i-1][1]);
            // 前一天冷却今天不动，前一天卖出今天冷却
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][0]);
        }

        return Math.max(dp[n-1][0],dp[n-1][2]);
    }

}
