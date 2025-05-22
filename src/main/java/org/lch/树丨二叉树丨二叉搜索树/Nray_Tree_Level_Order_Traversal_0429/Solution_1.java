package org.lch.树丨二叉树丨二叉搜索树.Nray_Tree_Level_Order_Traversal_0429;

import org.lch.树丨二叉树丨二叉搜索树.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_1 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> res = new ArrayList<>();
            while (size > 0){
                Node node = deque.pollFirst();
                res.add(node.val);
                List<Node> children = node.children;
                if (children != null){
                    for (Node child : children) {
                        deque.addLast(child);
                    }
                }
                size--;
            }
            resultList.add(res);
        }
        return resultList;
    }

}
