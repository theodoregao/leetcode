package p082;

public class Solution {
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode newHead = null, cur = null;
        
        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                if (newHead == null) newHead = head;
                else cur.next = head;
                cur = head;
            }
            head = skip(head);
        }
        
        if (cur != null) cur.next = null;
        return newHead;
    }
    
    private ListNode skip(ListNode head) {
        if (head == null) return null;
        int val = head.val;
        do {
            head = head.next;
        } while (head != null && head.val == val);
        return head;
    }
    
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}