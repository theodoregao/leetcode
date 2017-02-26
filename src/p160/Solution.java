package p160;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = length(headA);
		int lengthB = length(headB);
		if (lengthA > lengthB) headA = skip(headA, lengthA - lengthB);
		else headB = skip(headB, lengthB - lengthA);
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
	
	private int length(ListNode head) {
		if (head == null) return 0;
		int length = 1;
		while (head.next != null) {
			length++;
			head = head.next;
		}
		return length;
	}
	
	private ListNode skip(ListNode head, int n) {
		if (head == null) return null;
		while (n-- > 0) head = head.next;
		return head;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().getIntersectionNode(new ListNode(1), null));
	}
}