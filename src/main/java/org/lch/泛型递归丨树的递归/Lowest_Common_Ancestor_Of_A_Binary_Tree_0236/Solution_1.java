package org.lch.泛型递归丨树的递归.Lowest_Common_Ancestor_Of_A_Binary_Tree_0236;

import org.lch.TreeNode;

public class Solution_1 {

    // 递归的在左右节点里找 p 和 q，如果都找到了话，那说明当前节点就是最近的交汇点
    // 如果有一个为空，那么就使用从下面传上来的非空的值，这个交汇点会从下面传上来
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null) return root;

        return leftNode == null ? rightNode : leftNode;
    }

}
