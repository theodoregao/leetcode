package p141;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode first = head, last = head;
        while (last != null) {
            first = first.next;
            last = last.next;
            if (last == null) return false;
            last = last.next;
            if (first == last) return true;
        }
        return false;
    }
}