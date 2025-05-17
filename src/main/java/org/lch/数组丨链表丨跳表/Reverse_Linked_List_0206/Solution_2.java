package org.lch.数组丨链表丨跳表.Reverse_Linked_List_0206;


import org.lch.数组丨链表丨跳表.ListNode;

public class Solution_2 {

    // 递归
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 已经完成反转的链表
        ListNode curNode = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return curNode;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        reverseList(a);
    }
}
