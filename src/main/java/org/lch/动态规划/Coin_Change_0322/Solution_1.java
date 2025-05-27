package org.lch.动态规划.Coin_Change_0322;

import java.util.Arrays;

public class Solution_1 {

    // dp[i] 表示凑出金额 i 所需的最少硬币数
    // 可以先凑出 i-coin，再加上coin即可，而dp[i-coin] 正好已经算出来凑出i-coin最少用几枚了
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin){
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return dp[amount+1];
    }

}
