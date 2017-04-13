package p023;

import data.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        Heap heap = new Heap(lists);
        ListNode root = heap.removeTop();
        ListNode node = root;
        while (heap.size() > 0) {
            node.next = heap.removeTop();
            node = node.next;
        }
        if (node != null) node.next = null;
        return root;
    }
    
    static class Heap {
        ListNode[] items;
        int size;
        Heap(ListNode[] lists) {
            this.items = lists;
            size = items.length;
            for (int k = size; k >= 1; k--) sink(k);
        }
        
        public int size() { return size; }
        
        public ListNode removeTop() {
            if (size == 0) return null;
            ListNode top = items[0];
            items[0] = top.next;
            sink(1);
            return top;
        }
        
        private void sink(int k) {
            if (items[k - 1] == null) {
                swap(k, size--);
            }
            while (k * 2 <= size) {
                int j = k * 2;
                if (j < size && less(j, j + 1)) j++;
                if (!less(k, j)) break;
                swap(k, j);
                k = j;
            }
        }
        
        private boolean less(int i, int j) {
            return items[i - 1].val > items[j - 1].val;
        }
        
        private void swap(int i, int j) {
            ListNode node = items[i - 1];
            items[i - 1] = items[j - 1];
            items[j - 1] = node;
        }
    }
    
    public static void main(String[] args) {
//        new Solution().mergeKLists(new ListNode[] {null});
        new Solution().mergeKLists(new ListNode[] {new ListNode(1), new ListNode(2)});
    }
}