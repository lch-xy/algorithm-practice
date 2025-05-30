package org.lch.动态规划.Burst_Balloons_0312;

public class Solution_1 {

    /**
     * Input: nums = [3,1,5,8]
     * Output: 167
     * Explanation: nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
     * coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
     */
    // 区间动态规划 coins = nums[i-1] * nums[i] * nums[i+1]
    // dp[i][j] 表示戳破开区间 (i, j) 内所有气球能获得的最多金币（不包含 i 和 j）
    // 假设 k 是当前最后戳破的气球，i < k < j 标识，在(i,j) 之间我们都要去尝试戳破一下
    // 因为 k 是最后戳破的，所以邻居是i和j。
    // dp[i][j] = max(dp[i][j] , dp[i][k] + nums[i] * nums[k] * nums[j] + dp[k,j])
    // 为什么要定义最后一个被戳破？
    // 因为当前气球 i 的金币与“邻居”有关，先戳破会导致它的左右邻居发生变化，所以反过来思考假设 i 是最后被戳破的
    // 如何进行dp的递推？
    // dp[i][j]的计算依赖dp[i][k]和dp[k][j]
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] ballons = new int[n+2];
        ballons[0] = 1;
        ballons[n+1] = 1;
        for (int i = 0; i < n; i++) {
            ballons[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];

        // left 和 right 所包含的范围是[0,n-1]，但是我们计算的时候是开区间(0,n-1)，所以我们
        for (int len = 3; len <= n + 2; len++) {
            for (int left = 0; left + len - 1 <= n + 1; left++) {
                int right = left + len - 1;
                // k 其实是(left,right)这个范围
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][k] + ballons[left] * ballons[k] * ballons[right] + dp[k][right]);
                }
            }
        }

        return dp[0][n+1];
    }

}
