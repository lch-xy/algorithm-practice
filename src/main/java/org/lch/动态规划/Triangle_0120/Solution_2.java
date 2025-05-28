package org.lch.动态规划.Triangle_0120;

import java.util.Arrays;
import java.util.List;

public class Solution_2 {

    //    [2]
    //   [3,4]
    //  [6,5,7]
    // [4,1,8,3]]
    // 使用dfs + memo
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],Integer.MAX_VALUE);
        }
        return dfs(triangle,0,0,memo);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        if (i == triangle.size()) return 0;
        if (memo[i][j] != Integer.MAX_VALUE) return memo[i][j];

        int left = dfs(triangle,i+1,j,memo);
        int right = dfs(triangle,i+1,j+1,memo);

        memo[i][j] = Math.min(left,right) + triangle.get(i).get(j);

        return memo[i][j];
    }

}
