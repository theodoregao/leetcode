package p147;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode sort = head;
        head = head.next;
        sort.next = null;
        ListNode pre = null;
        ListNode temp = null;
        ListNode node = null;
        while (head != null) {
            temp = sort;
            pre = null;
            while (temp != null && temp.val < head.val) {
                pre = temp;
                temp = temp.next;
            }
            node = head;
            head = head.next;
            if (pre == null) {
                node.next = sort;
                sort = node;
            }
            else {
                node.next = pre.next;
                pre.next = node;
            }
        }
        return sort;
    }
    
    private static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }
    
    private static void insert(ListNode node, int val) {
        ListNode newNode = new ListNode(val);
        newNode.val = val;
        newNode.next = node.next;
        node.next = newNode;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        insert(head, 1);
        insert(head, 2);
        insert(head, 3);
        insert(head, 4);
        insert(head, 8);
        insert(head, 2);
        head = new Solution().insertionSortList(head);
        print(head);
    }
}