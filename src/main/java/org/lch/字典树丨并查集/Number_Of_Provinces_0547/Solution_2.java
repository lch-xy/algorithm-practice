package org.lch.字典树丨并查集.Number_Of_Provinces_0547;

public class Solution_2 {

    // 优化一下
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int start, boolean[] visited) {
        visited[start] = true;
        for (int j = 0; j < isConnected[start].length; j++) {
            if (isConnected[start][j] == 1 && !visited[j]) {
                dfs(isConnected, j,visited);
            }
        }
    }

}
