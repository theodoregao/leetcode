package p155;
public class MinStack {
    
    private Node head;
    private Node min;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        head = new Node(x, head);
        if (min == null || min.val >= x) min = new Node(x, min);
    }
    
    public void pop() {
        int value = top();
        if (head != null) head = head.next;
        if (value == min.val) min = min.next;
    }
    
    public int top() {
        if (head != null) return head.val;
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
        if (min != null) return min.val;
        return top();
    }
    
    private class Node {
        int val;
        Node next;
        
        public Node(int val, Node next) {
            this.next = next;
            this.val = val;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */