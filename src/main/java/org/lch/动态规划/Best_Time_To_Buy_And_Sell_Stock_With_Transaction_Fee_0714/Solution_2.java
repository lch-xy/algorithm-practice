package org.lch.动态规划.Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee_0714;

public class Solution_2 {

    // 使用状态机
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int hold = -prices[0];
        int sell = 0;

        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, sell - prices[i]);
            sell = Math.max(sell, hold + prices[i] - fee);
        }
        return sell;
    }

}
