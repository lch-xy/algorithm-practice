package org.lch.树丨二叉树丨二叉搜索树.Nary_Tree_Preorder_Traversal_0589;

import org.lch.树丨二叉树丨二叉搜索树.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_2 {

    public List<Integer> preorder(Node root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            resultList.add(node.val);
            List<Node> children = node.children;
            if (children != null){
                // 反一下 就能让左边的先出来了
                for (int i = children.size() - 1 ; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }
        return resultList;
    }


}
