package org.lch.泛型递归丨树的递归.Minimum_Depth_Of_Binary_Tree_0111;

import org.lch.TreeNode;

public class Solution_1 {

    /**
     *        2
     *   null    3
     * null    4   null
     *       5  null
     *     5
     * 分类讨论左右节点为空的情况 不要参与计算了，不然会导致是0
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;

        }
        if (root.right != null && root.left == null) {
            return minDepth(root.right) + 1;

        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

}
