package org.lch.动态规划.Coin_Change_II_0518;

public class Solution_1 {

    // 本质上是对硬币的组合 1+2 和 2+1 不能算两次
    // 组合的话 物品要放到外层
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
