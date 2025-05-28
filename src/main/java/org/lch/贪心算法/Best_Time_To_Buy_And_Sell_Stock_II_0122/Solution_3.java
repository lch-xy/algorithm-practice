package org.lch.贪心算法.Best_Time_To_Buy_And_Sell_Stock_II_0122;

public class Solution_3 {

    // 使用dp 因为只用了两个数据 所以可以将dp数组优化成两个常量
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < n; i++) {
            int newHold = Math.max(hold, cash - prices[i]);
            int newCash = Math.max(hold + prices[i], cash);
            hold = newHold;
            cash = newCash;
        }
        return cash;
    }

}
