package org.lch.高级搜索.Shortest_Path_In_Binary_Matrix_1091;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1 {

    private int[][] dirs = new int[][]{{-1,1},{0,1},{1,1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return -1;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> deque = new ArrayDeque<>();

        deque.addLast(new int[]{0,0});
        visited[0][0] = true; // 初始化标记 如果个标记放到for循环里面 就会超时

        int step = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int[] location = deque.pollFirst();
                int x = location[0];
                int y = location[1];
                if (x == m-1 && y == n-1){
                    return step;
                }
                if (grid[x][y] == 0) {
                    for (int[] dir : dirs) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        if (newX < 0 || newY < 0 || newX >= m || newY >= n || visited[newX][newY]) {
                            continue;
                        }
                        visited[newX][newY] = true;
                        deque.addLast(new int[]{newX,newY});
                    }
                }

            }
            step++;
        }
        return -1;
    }
}
