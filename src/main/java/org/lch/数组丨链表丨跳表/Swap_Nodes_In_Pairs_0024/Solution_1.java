package org.lch.数组丨链表丨跳表.Swap_Nodes_In_Pairs_0024;

import org.lch.数组丨链表丨跳表.ListNode;

public class Solution_1 {


    // 1 -> 2 -> 3 -> 4
    // 使用dummy虚拟节点来处理头节点的问题
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        // 从 dummy 开始，每次处理两个node
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        swapPairs(a);
    }
}
