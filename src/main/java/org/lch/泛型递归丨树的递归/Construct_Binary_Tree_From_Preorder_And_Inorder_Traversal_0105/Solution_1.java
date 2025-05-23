package org.lch.泛型递归丨树的递归.Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal_0105;

import org.lch.TreeNode;

public class Solution_1 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 得加上边界判断
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);

        // 可以定义全局的HashMap进行优化
        int mid = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                mid = i;
                break;
            }
        }

        node.left = helper(preorder, preStart + 1, preStart + mid - inStart, inorder, inStart, mid - 1);
        node.right = helper(preorder, preStart + mid - inStart + 1, preEnd, inorder, mid + 1, inEnd);
        return node;
    }

}
