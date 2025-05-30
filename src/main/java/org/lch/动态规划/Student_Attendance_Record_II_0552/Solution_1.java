package org.lch.动态规划.Student_Attendance_Record_II_0552;

public class Solution_1 {

    /**
     * 我们定义一个三维动态规划数组 dp[i][j][k]：
     * i 表示天数（1 到 n）
     * j 表示当前缺勤次数（0 表示没有缺勤，1 表示缺勤一次）
     * k 表示最是否迟到次数
     */
    public static int checkRecord(int n) {
        final int MOD = 1000000007;

        long[][][] dp = new long[n+1][3][2];

        // 0天时没有缺勤且没有迟到
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // 当天A缺勤
            dp[i][0][1] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0]) % MOD;

            // 当天P出席
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][1][0] + dp[i - 1][2][0]) % MOD;
            dp[i][0][1] = (dp[i][0][1] + dp[i - 1][0][1]+ dp[i - 1][1][1] + dp[i - 1][2][1]) % MOD;

            // 当天L迟到
            dp[i][1][0] = (dp[i - 1][0][0]) % MOD;
            dp[i][1][1] = (dp[i - 1][0][1]) % MOD;
            dp[i][2][0] = (dp[i - 1][1][0]) % MOD;
            dp[i][2][1] = (dp[i - 1][1][1]) % MOD;

        }

        long ans = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                ans = (ans + dp[n][i][j]) % MOD;
            }
        }
        return (int) ans;
    }


    public static void main(String[] args) {
        System.out.println(checkRecord(10101));
    }
}
