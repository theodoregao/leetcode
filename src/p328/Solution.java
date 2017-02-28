package p328;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddCur = odd;
        ListNode evenCur = even;
        head = even.next;
        int n = 0;
        while (head != null) {
            if (++n % 2 != 0) oddCur = oddCur.next = head;
            else evenCur = evenCur.next = head;
            head = head.next;
        }
        oddCur.next = even;
        evenCur.next = null;
        return odd;
    }
}