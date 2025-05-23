package org.lch.泛型递归丨树的递归.Validate_Binary_Search_Tree_0098;

import org.lch.TreeNode;

public class Solution_1 {

    // 使用Long 防止出现临界值的节点
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE) ;
    }

    private static boolean checkBST(TreeNode root, long minValue, long maxValue) {
        if (root == null){
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue){
            return false;
        }
        return checkBST(root.left, minValue, root.val) && checkBST(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
//        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(3);
//        root.left = left;
//        root.right = right;
        System.out.println(isValidBST(root));
    }
}
