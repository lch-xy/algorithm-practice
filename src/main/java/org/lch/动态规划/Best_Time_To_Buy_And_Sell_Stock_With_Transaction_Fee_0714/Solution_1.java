package org.lch.动态规划.Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee_0714;

public class Solution_1 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

}
