package org.lch.动态规划.Decode_Ways_0091;

public class Solution_1 {

    // dp[i] 表示前 i 个字符（s[0 ~ i-1]）的解码方法数量
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() ||s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1; // 空字符串有1种解法
        dp[1] = 1; // 第一个字符不为'0'，所以也只有1种解法

        for (int i = 2; i <= n; i++) {
            char one = s.charAt(i-2);
            char two = s.charAt(i-1);

            // 单字符能解码
            if (two != '0'){
                dp[i] += dp[i-1];
            }

            // 双字符能解码（10 - 26）
            int digit = (one - '0') * 10 + (two - '0');
            if (one != '0' && digit >= 10 && digit <=26){
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

}
