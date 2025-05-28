package org.lch.动态规划.Best_Time_To_Buy_And_Sell_Stock_IV_0188;

public class Solution_1 {

    // dp[i][k][0/1]:
    //  i 表示第几天（第 i 天）
    //  k 表示最多还能进行几次交易
    //  最后一个维度表示是否持有股票（0 表示不持有，1 表示持有）
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        int[][][] dp = new int[n][k + 1][2];

        // 第一天无论交易多少次 都是这个数
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // 当前没持有，要么昨天就没持有，要么今天卖掉
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // 当前持有，要么昨天就持有，要么今天买入（前提是还有 k-1 次机会）
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][k][0];
    }

}
