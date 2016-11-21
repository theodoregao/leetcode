package p086;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode curLess = less;
        ListNode large = new ListNode(0);
        ListNode curLarge = large;
        while(head != null) {
            if (head.val < x) {
                curLess.next = head;
                curLess = head;
                head = head.next;
                curLess.next = null;
            } else {
                curLarge.next = head;
                curLarge = head;
                head = head.next;
                curLarge.next = null;
            }
        }
        head = less.next;
        if (head == null) head = large.next;
        else curLess.next = large.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}