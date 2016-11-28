package p206;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur.next != null) {
            temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
        }
        
        cur.next = pre;
        
        return cur;
    }
}