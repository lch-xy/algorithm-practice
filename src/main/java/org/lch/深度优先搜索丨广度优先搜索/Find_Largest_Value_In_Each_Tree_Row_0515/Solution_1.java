package org.lch.深度优先搜索丨广度优先搜索.Find_Largest_Value_In_Each_Tree_Row_0515;

import org.lch.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_1 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (max < node.val){
                    max = node.val;
                }
                if (node.left != null){
                    deque.addLast(node.left);
                }
                if (node.right != null){
                    deque.addLast(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

}
