package org.lch.字典树丨并查集.Number_Of_Provinces_0547;

import org.lch.UnionFind;

public class Solution_3 {

    // 并查集
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }

        return uf.count();
    }




}
