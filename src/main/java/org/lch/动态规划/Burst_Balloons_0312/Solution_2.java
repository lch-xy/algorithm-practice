package org.lch.动态规划.Burst_Balloons_0312;

public class Solution_2 {

    // 使用dfs 也是枚举每个k作为最后一个戳破的气球
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        balloons[0] = 1;
        balloons[n+1] = 1;
        for (int i = 0; i < n; i++) {
            balloons[i+1] = nums[i];
        }

        int[][] memo = new int[n+2][n+2];
        return dfs(balloons, 0, n + 1, memo);
    }

    private int dfs(int[] balloons, int left, int right, int[][] memo) {
        // 挨着了
        if (left + 1 >= right) return 0;
        if (memo[left][right] > 0) return memo[left][right];

        int res = 0;

        for (int k = left + 1; k < right; k++) {
            int score = balloons[left] * balloons[k] * balloons[right];
            int leftScore = dfs(balloons, left, k, memo);
            int rightScore = dfs(balloons, k, right, memo);
            res = Math.max(res, score + leftScore + rightScore);
        }
        memo[left][right] = res;
        return res;
    }

}
