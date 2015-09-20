package google.leetcode023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        Queue<ListNode> queue = new LinkedList<ListNode>(Arrays.asList(lists));
        while (queue.size() > 1) queue.offer(mergeLists(queue.poll(), queue.poll()));
        return queue.poll();
    }
    
    public ListNode mergeLists(ListNode a, ListNode b) {
        ListNode root = new ListNode(0);
        ListNode node = root;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                node.next = a;
                a = a.next;
            }
            else {
                node.next = b;
                b = b.next;
            }
            node = node.next;
        }
        if (a != null) node.next = a;
        if (b != null) node.next = b;
        
        return root.next;
    }
}