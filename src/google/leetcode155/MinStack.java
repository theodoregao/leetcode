package google.leetcode155;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 
 * @author Theodore
 *
 *  两个栈，值可能重复
 */
class MinStack {
    
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    private Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()) minStack.push(x);
        if (!counts.containsKey(x)) counts.put(x, 1);
        else counts.put(x, counts.get(x) + 1);
    }

    public void pop() {
        int x = stack.pop();
        counts.put(x, counts.get(x) - 1);
        if (minStack.peek() == x && counts.get(x) <= 0) minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
