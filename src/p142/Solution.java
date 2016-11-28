package p142;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode root = new ListNode(0);
        root.next = head;
        boolean hasCycle = false;
        ListNode first = root, last = root;
        while (last != null) {
            first = first.next;
            last = last.next;
            if (last == null) return null;
            if (!hasCycle) last = last.next;
            if (first == last) {
                if (hasCycle) return last;
                else {
                    first = root;
                    hasCycle = true;
                }
            }
        }
        return null;
    }
}