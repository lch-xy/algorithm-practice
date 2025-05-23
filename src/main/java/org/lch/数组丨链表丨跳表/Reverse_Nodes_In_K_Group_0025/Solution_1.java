package org.lch.数组丨链表丨跳表.Reverse_Nodes_In_K_Group_0025;

import org.lch.ListNode;

/**
 * @Author: LCH
 * @Date: 2025/5/14 23:03
 */
public class Solution_1 {

    // 每次处理前k个节点 然后递归调用reverseKGroup
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int step = 0;
        ListNode checkNode = head;
        while (step < k){
            if (checkNode == null){
                return head;
            }
            checkNode = checkNode.next;
            step++;
        }

        // 为什么pre从null起手？因为cur.next往回指的时候，最开始头指针的next肯定是null
        // next指针的作用？起到保存的作用，因为cur已经改变了位置，所以需要用next指针记录下一个位置
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        int count = 0;
        // 还没开始前cur的位置已经在第一个节点了，所以当处理完k个节点，cur就已经在k+1的位置了，也就是下一段链表的头
        // 所以最后返回是pre
        while (count < k){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count++;
        }

        // next如果不为空 代表后面还有链条
        if (next != null){
            // 翻转后 head 就是tail，与下一端的头相连接
            head.next = reverseKGroup(next,k);
        }

        return pre;
    }
}
