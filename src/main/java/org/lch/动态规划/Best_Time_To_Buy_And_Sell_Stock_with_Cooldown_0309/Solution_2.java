package org.lch.动态规划.Best_Time_To_Buy_And_Sell_Stock_with_Cooldown_0309;

public class Solution_2 {

    // 使用状态机
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        int hold = -prices[0];
        int sell = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            // 当天持有股票的最大利润
            int newHold = Math.max(hold,rest-prices[i]);
            // 当天卖出股票的最大利润
            int newSell = hold + prices[i];
            // 当天休息的最大利润
            int newRest = Math.max(rest,sell);

            hold = newHold;
            sell = newSell;
            rest = newRest;
        }

        return Math.max(sell,rest);
    }

}
