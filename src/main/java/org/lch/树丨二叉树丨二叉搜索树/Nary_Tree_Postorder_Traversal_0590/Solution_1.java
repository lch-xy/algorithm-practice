package org.lch.树丨二叉树丨二叉搜索树.Nary_Tree_Postorder_Traversal_0590;

import org.lch.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    public List<Integer> postorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        helper(root,resultList);
        return resultList;
    }

    private void helper(Node root, List<Integer> resultList) {
        if (root == null){
            return;
        }
        List<Node> children = root.children;
        if (children != null){
            for (Node child : children) {
                helper(child,resultList);
            }
        }
        resultList.add(root.val);
    }
}
