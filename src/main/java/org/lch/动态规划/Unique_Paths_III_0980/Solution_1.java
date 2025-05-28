package org.lch.动态规划.Unique_Paths_III_0980;

import java.util.HashSet;
import java.util.Set;

public class Solution_1 {

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] start = new int[2];
        int[] end = new int[2];
        Set<String> obstacles = new HashSet<>();
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start = new int[]{i, j};
                } else if (grid[i][j] == 2) {
                    end = new int[]{i, j};
                    step++;
                } else if (grid[i][j] == -1) {
                    obstacles.add(i + "," + j);
                } else {
                    step++;
                }
            }
        }
        visited[start[0]][start[1]] = true;
        return dfs(grid,start[0],start[1], end, obstacles, 0, step, visited);
    }

    private int dfs(int[][] grid, int x, int y, int[] end, Set<String> obstacles, int curStep, int step, boolean[][] visited) {
        if (x == end[0] && y == end[1] && curStep == step){
            return 1;
        }
        int cnt = 0;
        for (int[] dir : dirs) {
            int newX = dir[0] + x;
            int newY = dir[1] + y;

            // 为什么在这里进行判定而不是在方法开始的时候？
            // 因为visited数组可能越界
            if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length &&
                    !obstacles.contains(newX + "," + newY) && !visited[newX][newY]) {
                visited[newX][newY] = true;
                cnt += dfs(grid, newX, newY, end, obstacles, curStep + 1, step, visited);
                visited[newX][newY] = false;
            }
        }
        return cnt;
    }

}
