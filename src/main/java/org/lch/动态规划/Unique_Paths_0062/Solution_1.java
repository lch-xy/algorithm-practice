package org.lch.动态规划.Unique_Paths_0062;

public class Solution_1 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 第一列初始化的时候别弄反了
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
