package org.lch.树丨二叉树丨二叉搜索树.Nary_Tree_Postorder_Traversal_0590;

import org.lch.树丨二叉树丨二叉搜索树.Node;

import java.util.*;

public class Solution_2 {

    // 使用头插法 + 逆前序
    // 中-左-右 -> 中-右-左 --反转--> 左-右-中
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> resultList = new LinkedList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            resultList.addFirst(node.val);

            if (node.children != null){
                for (Node child : node.children) {
                    // 进栈是 左 -> 右，出栈就是 右 -> 左
                    stack.push(child);
                }
            }
        }
        return resultList;
    }

}
