package org.lch.数组丨链表丨跳表.Swap_Nodes_In_Pairs_0024;

import org.lch.ListNode;

public class Solution_2 {


    // 1 -> 2 -> 3 -> 4
    // 可以正确处理奇数和偶数节点
    // 如果是奇数，会直接返回当前节点，与前面节点连接
    // 如果是偶数，则会返回翻转后的节点，与前面节点连接
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        // curNode肯定是当前列表的头结点
        ListNode curNode = head.next;
        // 递归的去连接每个小段
        head.next = swapPairs(curNode.next);
        curNode.next = head;

        return curNode;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
//        c.next = d;
        swapPairs(a);
    }
}
