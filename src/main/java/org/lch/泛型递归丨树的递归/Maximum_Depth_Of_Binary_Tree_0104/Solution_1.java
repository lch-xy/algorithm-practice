package org.lch.泛型递归丨树的递归.Maximum_Depth_Of_Binary_Tree_0104;

import org.lch.TreeNode;

public class Solution_1 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
