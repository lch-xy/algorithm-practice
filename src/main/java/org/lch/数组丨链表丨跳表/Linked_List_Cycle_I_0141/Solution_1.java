package org.lch.数组丨链表丨跳表.Linked_List_Cycle_I_0141;

import org.lch.数组丨链表丨跳表.ListNode;

public class Solution_1 {

    // 基于快慢指针，只即可判断fast指针极客
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
