package org.lch.树丨二叉树丨二叉搜索树.Binary_Tree_Preorder_Traversal_0144;

import org.lch.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_2 {

    // 迭代
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                resultList.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            // 这里的stack只是用来寻找右边的数据
            TreeNode node = stack.pop();
            cur = node.right;
        }
        return resultList;
    }


}
