package org.lch.动态规划.Maximal_Square_0221;

public class Solution_1 {

    // dp[i][j] 表示以 (i,j) 为右下角的正方形最大边长。
    // 如果(i,j) = '1' && 上 左上 左 三个方块取最小的那个
    // 因为 上 左上 左 三个正方形+(i,j)这个点，已经将(i,j)为右下角的正方形包含了
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }

}
