package org.lch.动态规划.Unique_Paths_III_0980;

public class Solution_3 {

    // 示例代码

    int res = 0;
    int rows, cols;
    int[][] grid;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;

        int sx = 0, sy = 0, empty = 0;

        // 1. 找起点、统计可以走的格子数（包括起点）
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) {
                    empty++;
                }
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                }
            }
        }

        // 2. 从起点开始 DFS
        dfs(sx, sy, empty);
        return res;
    }

    private void dfs(int x, int y, int remain) {
        // 越界或碰到障碍或已经访问过
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == -1) return;

        // 如果到达终点
        if (grid[x][y] == 2) {
            if (remain == 0) res++;  // 所有格子恰好走完
            return;
        }

        // 保存当前格子，标记为访问过
        int temp = grid[x][y];
        grid[x][y] = -1; // 标记为已访问

        // 继续 4 个方向探索
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, remain - 1);
        }

        // 回溯：还原格子
        grid[x][y] = temp;
    }

}
