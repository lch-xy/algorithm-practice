package org.lch;

public class UnionFind {

    int[] parent;

    // 表示以 i 为根的集合的大小
    int[] size;

    // 当前连通块个数
    int count = 0;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        count = n;
        // 初始化每个父节点是自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if (parent[x] != x) {
            // 路径压缩 每次
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY){
            return;
        }
        // 小树挂到大树下
        if (size[rootX] < size[rootY]){
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        count--;
    }

    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}
