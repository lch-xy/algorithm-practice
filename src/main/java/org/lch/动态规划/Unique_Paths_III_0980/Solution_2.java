package org.lch.动态规划.Unique_Paths_III_0980;

public class Solution_2 {

    /**
     * 精简代码
     */
    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] start = new int[2];
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 0) {
                    step++;
                }
                if (grid[i][j] == 1){
                    start = new int[]{i, j};
                }
            }
        }
        visited[start[0]][start[1]] = true;
        return dfs(grid, start[0], start[1], step, visited);
    }

    private int dfs(int[][] grid, int x, int y, int step, boolean[][] visited) {
        if (grid[x][y] == 2 && step == 0) {
            return 1;
        }
        int cnt = 0;
        for (int[] dir : dirs) {
            int newX = dir[0] + x;
            int newY = dir[1] + y;

            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length &&
                    grid[newX][newY] != -1 && !visited[newX][newY]) {
                visited[newX][newY] = true;
                cnt += dfs(grid, newX, newY, step - 1, visited);
                visited[newX][newY] = false;
            }
        }
        return cnt;
    }

}
