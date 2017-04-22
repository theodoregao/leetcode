package p203;

import data.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(0);
        ListNode cur = h;
        while (head != null) {
            if (head.val != val) {
                cur.next = head;
                head = head.next;
                cur = cur.next;
            }
            else head = head.next;
            cur.next = null;
        }
        return h.next;
    }
}