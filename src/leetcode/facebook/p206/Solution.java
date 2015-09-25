package leetcode.facebook.p206;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        ListNode previous = null;
        while (head.next != null) {
            node = head;
            head = head.next;
            node.next = previous;
            previous = node;
        }
        head.next = previous;
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        
        head = new Solution().reverseList(head);
        
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}