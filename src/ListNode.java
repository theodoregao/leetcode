public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    
    public void print() {
        ListNode h = this;
        while (h != null) {
            System.out.print(h.val + " -> ");
            h = h.next;
        }
        System.out.println("null");
    }
}