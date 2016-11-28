package p024;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        head = swap(head);
        
        ListNode prev = head.next;
        ListNode cur = head.next.next;
        while (cur != null && cur.next != null) {
            cur = swap(cur);
            prev.next = cur;
            prev = cur.next;
            cur = cur.next.next;
        }
        
        return head;
    }
    
    private ListNode swap(ListNode first) {
        ListNode temp = first;
        first = first.next;
        temp.next = first.next;
        first.next = temp;
        return first;
    }
}