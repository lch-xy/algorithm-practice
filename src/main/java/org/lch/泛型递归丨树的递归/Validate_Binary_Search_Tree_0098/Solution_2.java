package org.lch.泛型递归丨树的递归.Validate_Binary_Search_Tree_0098;

import org.lch.TreeNode;

public class Solution_2 {

    Long preVal = Long.MIN_VALUE;

    // 使用中序遍历 左 中 右
    // 跟前一个节点比较
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) return false;
        if (root.val <= preVal) return false;
        preVal = (long) root.val;
        return isValidBST(root.right);
    }

}
