package org.lch.字典树丨并查集.Word_Search_II_212;


import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    private TreeNode root = new TreeNode();
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;

        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, new StringBuilder(),root);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int x, int y, StringBuilder cur,TreeNode node) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '#') return;

        char ch = board[x][y];
        if (node.children[ch - 'a'] == null){
            return;
        }

        node = node.children[ch - 'a'];
        cur.append(ch);

        if (node.isEnd){
            res.add(cur.toString());
            node.isEnd = false; // 去重
            // 这里不能 return 因为后面可能还有单词
        }

        board[x][y] = '#';
        for (int[] dir : dirs) {
            dfs(board,x+dir[0],y+dir[1],cur,node);
        }
        board[x][y] = ch;
        // 使用StringBuilder需要回溯，如果是String 则不用
        cur.deleteCharAt(cur.length() - 1);
    }

    class TreeNode {
        private TreeNode[] children = new TreeNode[26];
        private boolean isEnd = false;
    }

    public void insert(String word) {
        TreeNode curNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curNode.children[index] == null){
                curNode.children[index] = new TreeNode();
            }
            curNode = curNode.children[index];
        }
        curNode.isEnd = true;
    }
}
