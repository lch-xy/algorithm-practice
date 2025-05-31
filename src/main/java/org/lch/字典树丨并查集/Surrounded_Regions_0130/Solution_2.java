package org.lch.字典树丨并查集.Surrounded_Regions_0130;

public class Solution_2 {



    // 思路：使用并查集将边界 O 连接到一个虚拟节点
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        UnionFind uf = new UnionFind(board);

        int dummy = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int id = i * n + j;
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        uf.union(id, dummy);
                    } else {
                        // 这里必须得进行上下左右的的判断，
                        if (board[i - 1][j] == 'O') uf.union(id, (i - 1) * n + j);
                        if (i < m - 1 && board[i + 1][j] == 'O') uf.union(id, (i + 1) * n + j);
                        if (board[i][j - 1] == 'O') uf.union(id, i * n + j - 1);
                        if (j < n - 1 && board[i][j + 1] == 'O') uf.union(id, i * n + j + 1);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O'){
                    int id = i * n + j;
                    if (uf.find(id) != uf.find(dummy)){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    static class UnionFind {
        int[] parent;

        int count = 0;

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n + 1];
            for (int i = 0; i < m * n + 1; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }


}
