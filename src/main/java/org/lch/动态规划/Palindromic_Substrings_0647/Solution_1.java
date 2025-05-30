package org.lch.动态规划.Palindromic_Substrings_0647;

public class Solution_1 {

    // dp[i][j] 来表示子串 s[i...j] 是否是回文
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        // dp[i][j] 表示 s[i...j] 是否是回文
        boolean[][] dp = new boolean[n][n];

        // 遍历所有子串的长度
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (len == 1) {
                    dp[i][j] = true;
                    count++;
                } else if (len == 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    // 这里是[i+1,j-1]
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
