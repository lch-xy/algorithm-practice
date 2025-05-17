package org.lch.数组丨链表丨跳表.Reverse_Linked_List_0206;


import org.lch.数组丨链表丨跳表.ListNode;

public class Solution_1 {

    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
