package org.lch.动态规划.Longest_Commo_Subsequence_1143;

public class Solution_1 {

    // dp[i][j]: text1[0..i-1] 和 text2[0..j-1] 的最长公共子序列长度。
    // dp[0][0]: 代表空串
    // dp中的i 对应这 text中的 i-1
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
