package org.lch.深度优先搜索丨广度优先搜索.Number_Of_Inlands_0200;

public class Solution_2 {

    private int[][] dirs = new int[][]{{1,0},{0,1}};
    // 使用并查集
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    int id = i * n + j;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        int newId = x * n +y;
                        if (x < m && y < n && grid[x][y] == '1') {
                            uf.union(id,newId);
                        }
                    }
                }
            }
        }
        return uf.count;
    }


    static class UnionFind {
        int[] parent;

        int count;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            count = 0;
            parent = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int id = i * n + j;
                    parent[id] = id;
                    if (grid[i][j] == '1'){
                        count++;
                    }
                }
            }
        }

        public int find(int x){
            if (parent[x] != x){
                parent[x]= find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y ) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }

        public int getCount(){
            return count;
        }
    }

}
