package org.lch.数组丨链表丨跳表.Linked_List_Cycle_II_0142;

import org.lch.ListNode;

/**
 * @Author: LCH
 * @Date: 2025/5/14 22:23
 */
public class Solution_1 {

    // 链表的非环部分长度为 a，环的长度为 b。
    // slow 和 fast 在环内相遇时，slow 走了 a+x 步，其中 x 是环内的某个位置。
    // fast 走了 a+x+k⋅b 步，其中 k 是某个整数，表示 fast 在环内多走了 k 圈。
    // 2(a+x)=a+x+k⋅b
    // a+x=k⋅b
    // a=k⋅b−x -> a = b(k-1) + (b-x)
    // 可以推出，slow指针从头走到a处，fast指针一样
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        boolean isCycle = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                isCycle = true;
                break;
            }
        }
        if (!isCycle){
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
