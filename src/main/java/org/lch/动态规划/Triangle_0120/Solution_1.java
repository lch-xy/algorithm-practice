package org.lch.动态规划.Triangle_0120;

import java.util.List;

public class Solution_1 {

    //    [2]
    //   [3,4]
    //  [6,5,7]
    // [4,1,8,3]]
    // 我从底层向上遍历，可以看到 下面一层的i和(i+1)对应的是上一次i
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 防止下面j+1的时候越界
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }

}
