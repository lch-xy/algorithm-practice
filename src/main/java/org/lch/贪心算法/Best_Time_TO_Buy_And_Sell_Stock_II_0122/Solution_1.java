package org.lch.贪心算法.Best_Time_TO_Buy_And_Sell_Stock_II_0122;

public class Solution_1 {

    // 使用贪心算法
    // 为什么“只要明天价格比今天高，就今天买、明天卖”是最优策略？
    // 可以进行多次交易 + 可以当天买卖 + 没有手续费
    // 所以即使 [5,7,10]，我们可以整段持有 10-5=5，也可以初步交易 7-5 + 10-7 = 5
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]){
                maxProfit += (prices[i]-prices[i-1]);
            }
        }
        return maxProfit;
    }

}
