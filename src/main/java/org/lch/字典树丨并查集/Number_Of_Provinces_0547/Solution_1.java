package org.lch.字典树丨并查集.Number_Of_Provinces_0547;

public class Solution_1 {

    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1){
                    isConnected[i][j] = 0;
                    dfs(isConnected,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int start) {
        for (int j = 0; j < isConnected[start].length ; j++) {
            if (isConnected[start][j] == 1){
                isConnected[start][j] = 0;
                dfs(isConnected,j);
            }
        }
    }

}
