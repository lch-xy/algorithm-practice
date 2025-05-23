package org.lch.泛型递归丨树的递归.Invert_Binary_Tree_0226;

import org.lch.TreeNode;

public class Solution_1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
