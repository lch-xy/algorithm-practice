package org.lch.树丨二叉树丨二叉搜索树.Binary_Tree_Inorder_Traversal_0094;

import org.lch.树丨二叉树丨二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {
    // 前序遍历 左中右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        helper(root,resultList);
        return resultList;
    }

    private void helper(TreeNode root,List<Integer> resultList) {
        if (root == null){
            return;
        }
        helper(root.left,resultList);
        resultList.add(root.val);
        helper(root.right,resultList);
    }

}
