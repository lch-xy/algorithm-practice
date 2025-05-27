package org.lch.贪心算法.Best_Time_TO_Buy_And_Sell_Stock_II_0122;

public class Solution_2 {

    // 使用dp
    // 因为存在持有和不持有的两种状态
    // 而今的持有和不持有也可以通过买、卖、不动三种操作来实现
    // 所以我们需要用二维数组去记录持有和不持有的最优解
    // dp[i][0]:第i天持有股票的最大利润
    // dp[i][1]:第i天不持有股票的最大利润
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 什么时候是n？什么时候是n+1？
        // 是否用 n+1，取决于你是否把“第 0 天”作为一个“前置状态”（比如：啥都没做的时候）来统一处理。
        // 或者为了处理边界统一
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0]; // 第一天买入股票，利润为负
        dp[0][1] = 0; // 第一天纹丝不动

        for (int i = 1; i < n; i++) {
            // 昨天持有，今天不动 | 昨天没有，今天买入
            dp[i][0] = Math.max(dp[i-1][0] ,dp[i-1][1] - prices[i]);
            // 昨天持有，今天卖出 | 昨天没有，今天不动
            dp[i][1] = Math.max(dp[i-1][0] + prices[i]  ,dp[i-1][1]);
        }

        return dp[n-1][1];
    }

}
