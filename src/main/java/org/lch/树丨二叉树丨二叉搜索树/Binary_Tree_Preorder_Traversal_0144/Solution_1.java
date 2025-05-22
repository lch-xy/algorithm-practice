package org.lch.树丨二叉树丨二叉搜索树.Binary_Tree_Preorder_Traversal_0144;

import org.lch.树丨二叉树丨二叉搜索树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    // 中序遍历 中左右
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        helper(root,resultList);
        return resultList;
    }

    private void helper(TreeNode root, List<Integer> resultList) {
        if (root == null){
            return;
        }
        resultList.add(root.val);
        helper(root.left,resultList);
        helper(root.right,resultList);
    }
}
