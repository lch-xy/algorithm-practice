package org.lch.动态规划.Edit_Distance_0072;

public class Solution_1 {

    /**
     * 这题重点
     *
     * 如果 word1[i - 1] == word2[j - 1]：
     *     dp[i][j] = dp[i - 1][j - 1]
     *
     * 否则（不相等）：
     *     dp[i][j] = 1 + min(
     *         dp[i - 1][j],     // 删除
     *         dp[i][j - 1],     // 插入
     *         dp[i - 1][j - 1]  // 替换
     *     )
     *
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        // 把 word1 前 i 个字符变成空串，需要删除 i 次
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        // 把空串变成 word2 前 j 个字符，需要插入 j 次
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i-1][j-1],dp[i][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
