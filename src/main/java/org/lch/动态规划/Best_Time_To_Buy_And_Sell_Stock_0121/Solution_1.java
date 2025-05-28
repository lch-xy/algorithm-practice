package org.lch.动态规划.Best_Time_To_Buy_And_Sell_Stock_0121;

public class Solution_1 {

    // 贪心算法
    // 因为只能买卖一次 可以记录下最低价，往后的每一天都卖一次看看利润，记录最大利润
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }

}
