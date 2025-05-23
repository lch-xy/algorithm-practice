package org.lch.数组丨链表丨跳表.Merge_Two_Sorted_Lists_0021;

import org.lch.ListNode;

public class Solution_1 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null  && list2 != null){
            if (list1.val > list2.val){
                cur.next = list2;
                list2 = list2.next;
            }else{
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        while (list1 != null){
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        while (list2 != null){
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode aa = new ListNode(-9);
        ListNode bb = new ListNode(3);
        ListNode cc = new ListNode(5);
        ListNode dd = new ListNode(7);
        aa.next = bb;
        cc.next = dd;

        mergeTwoLists(aa,cc);
    }
}
