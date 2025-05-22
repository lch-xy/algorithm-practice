package org.lch.树丨二叉树丨二叉搜索树.Nary_Tree_Preorder_Traversal_0589;

import org.lch.树丨二叉树丨二叉搜索树.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        helper(root,resultList);
        return resultList;
    }

    private void helper(Node root, List<Integer> resultList) {
        if (root == null){
            return;
        }
        resultList.add(root.val);
        List<Node> children = root.children;
        if (children != null){
            for (Node child : children) {
                helper(child,resultList);
            }
        }
    }
}
