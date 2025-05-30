package org.lch.字典树丨并查集.Implement_Trie_Prefix_Tree_0208;

public class Trie {

    // 因为是字母，所以可以使用数组的方式来做，汉字的话可以使用HashMap来做

    private TreeNode root;

    public Trie() {
        root = new TreeNode();
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

    public boolean search(String word) {
        TreeNode curNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curNode.children[index] == null){
                return false;
            }
            curNode = curNode.children[index];
        }
        if (curNode.isEnd){
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TreeNode curNode = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (curNode.children[index] == null){
                return false;
            }
            curNode = curNode.children[index];
        }
        return true;
    }


    class TreeNode {
        private TreeNode[] children = new TreeNode[26];
        private boolean isEnd = false;
    }

}
