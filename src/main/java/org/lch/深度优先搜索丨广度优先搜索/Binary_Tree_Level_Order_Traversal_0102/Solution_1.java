package org.lch.深度优先搜索丨广度优先搜索.Binary_Tree_Level_Order_Traversal_0102;

import org.lch.TreeNode;

import java.util.*;

public class Solution_1 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> levelVal = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                levelVal.add(treeNode.val);
                if (treeNode.left != null){
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.addLast(treeNode.right);
                }
            }
            res.add(levelVal);
        }
        return res;
    }

}
