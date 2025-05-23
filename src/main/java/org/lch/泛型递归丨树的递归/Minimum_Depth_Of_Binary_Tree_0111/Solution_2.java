package org.lch.泛型递归丨树的递归.Minimum_Depth_Of_Binary_Tree_0111;

import org.lch.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2 {

    /**
     * 使用队列 逐层扫描 碰到左右节点为空的情况 就可以返回了
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        int depth = 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.left != null){
                    deque.addLast(node.left);
                }
                if (node.right !=null){
                    deque.addLast(node.right);
                }
                if (node.left == null && node.right == null){
                    return depth;
                }
            }
            depth++;
        }
        return depth;
    }

}
