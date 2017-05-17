package p002;

import data.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        ListNode pre = cur;
        while (l1 != null && l2 != null) {
            ListNode next = new ListNode((cur.val + l1.val + l2.val) / 10);
            cur.val = (cur.val + l1.val + l2.val) % 10;
            cur.next = next;
            pre = cur;
            cur = next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            ListNode next = new ListNode((cur.val + l1.val) / 10);
            cur.val = (cur.val + l1.val) % 10;
            cur.next = next;
            pre = cur;
            cur = next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode next = new ListNode((cur.val + l2.val) / 10);
            cur.val = (cur.val + l2.val) % 10;
            cur.next = next;
            pre = cur;
            cur = next;
            l2 = l2.next;
        }
        if (cur.val == 0 && cur != result) pre.next = null;
        return result;
    }
}