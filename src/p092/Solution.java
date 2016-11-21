package p092;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode list = new ListNode(0);
        list.next = head;
        if (m >= n) return head;
        ListNode listNode = list;
        int k = m;
        while (--k > 0) listNode = listNode.next;
        listNode.next = reverse(listNode, n - m + 1);
        return list.next;
    }
    
    private ListNode temp;
    
    public ListNode reverse(ListNode head, int n) {
        ListNode node = reverse(null, head.next, n);
        head.next.next = temp;
        return node;
    }
    
    public ListNode reverse(ListNode parent, ListNode node, int n) {
        ListNode rootNode = parent;
        if (n-- > 0) {
            rootNode = reverse(node, node.next, n);
            node.next = parent;
        }
        else {
            temp = node;
        }
        return rootNode;
    }
    
    
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i <= 2; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        
        head = new Solution().reverseBetween(head, 1, 2);
        while (head.next != null) {
            head = head.next;
            System.out.println(head.val);
        }
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}