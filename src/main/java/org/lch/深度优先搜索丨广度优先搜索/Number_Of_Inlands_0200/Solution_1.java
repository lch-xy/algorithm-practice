package org.lch.深度优先搜索丨广度优先搜索.Number_Of_Inlands_0200;

public class Solution_1 {

    // 不需要visited数组，直接对grid进行修改即可
    // 找打一个为1的就可以count++ 再使用递归将相邻为1的island变成0
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length ||grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';

        dfs(grid,row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);
    }

}
