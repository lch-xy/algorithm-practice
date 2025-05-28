package org.lch.动态规划.Best_Time_To_Buy_And_Sell_Stock_III_0123;

public class Solution_1 {

    // 使用状态机来做 定义四种状态:
    // firstBuy：买入第一只股票后你最多还剩多少钱（负数）
    // firstSell：第一次卖掉后的利润
    // secondBuy：用 firstSell 的利润去再买一次
    // secondSell：最终卖掉第二只股票后的总利润
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            firstBuy = Math.max(firstBuy,-price);
            firstSell = Math.max(firstSell,firstBuy+price);
            secondBuy = Math.max(secondBuy,firstSell-price);
            secondSell = Math.max(secondSell,secondBuy + price);
        }

        return secondSell;
    }

}
