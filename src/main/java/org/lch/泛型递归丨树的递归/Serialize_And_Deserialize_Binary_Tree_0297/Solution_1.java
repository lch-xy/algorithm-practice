package org.lch.泛型递归丨树的递归.Serialize_And_Deserialize_Binary_Tree_0297;

import org.lch.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (node.val == -10000){
                    sb.append(",#");
                    continue;
                }else {
                    sb.append(",").append(node.val);
                }
                if (node.left == null) {
                    deque.addLast(new TreeNode(-10000));
                } else {
                    deque.addLast(node.left);
                }
                if (node.right == null) {
                    deque.addLast(new TreeNode(-10000));
                } else {
                    deque.addLast(node.right);
                }
            }
        }
        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] split = data.split(",");
        int start = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[start++]));
        deque.addLast(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            if ("#".equals(split[start])){
                node.left = null;
            }else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(split[start]));
                node.left = leftNode;
                deque.addLast(leftNode);
            }
            start++;
            if ("#".equals(split[start])){
                node.right = null;
            }else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(split[start]));
                node.right = rightNode;
                deque.addLast(rightNode);
            }
            start++;
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode a= new TreeNode(1);
        TreeNode b= new TreeNode(2);
        TreeNode c= new TreeNode(3);
        TreeNode d= new TreeNode(4);
//        TreeNode e= new TreeNode(5);
//        TreeNode f= new TreeNode(6);

        a.left = b;
        a.right = c;
        c.left = d;
//        c.right = e;
//        e.right = f;
        String data = serialize(a);
        System.out.println(data);

        TreeNode node = deserialize(data);
        System.out.println(node);
    }
}
