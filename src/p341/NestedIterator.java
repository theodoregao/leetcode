package p341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
 
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
 
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
 
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        if (nestedList != null) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                push(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        check();
        return stack.pop().getInteger();
    }
    
    private void push(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) stack.push(nestedInteger);
        else {
            List<NestedInteger> nestedList = nestedInteger.getList();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
    }
    
    private void check() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) push(stack.pop());
    }

    @Override
    public boolean hasNext() {
        check();
        return !stack.isEmpty();
    }
}

/**
Your NestedIterator object will be instantiated and called as such:
NestedIterator i = new NestedIterator(nestedList);
while (i.hasNext()) v[f()] = i.next();
 */