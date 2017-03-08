package p364;

import java.util.List;

interface NestedInteger {
//    // Constructor initializes an empty nested list.
//    public NestedInteger();
//
//    // Constructor initializes a single integer.
//    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to
    // it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a
    // nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return depthSumInverse(nestedList, getHeight(nestedList, 1));
    }
    
    private int getHeight(List<NestedInteger> nestedList, int height) {
        int maxHeight = height;
        for (NestedInteger nestedInteger: nestedList)
            if (!nestedInteger.isInteger())
                maxHeight = Math.max(maxHeight, getHeight(nestedInteger.getList(), height + 1));
        return maxHeight;
    }
    
    private int depthSumInverse(List<NestedInteger> nestedList, int height) {
        int sum = 0;
        for (NestedInteger nestedInteger: nestedList)
            if (nestedInteger.isInteger())
                sum += height * nestedInteger.getInteger();
            else sum += depthSumInverse(nestedInteger.getList(), height - 1);
        return sum;
    }
}