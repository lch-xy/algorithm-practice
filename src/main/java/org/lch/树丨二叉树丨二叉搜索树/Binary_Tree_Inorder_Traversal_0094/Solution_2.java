package org.lch.树丨二叉树丨二叉搜索树.Binary_Tree_Inorder_Traversal_0094;

import org.lch.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_2 {
    // 使用stack辅助 迭代遍历完成
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode node = stack.pop();
            resultList.add(node.val);

            cur = node.right;
        }
        return resultList;
    }


}
