package p339;

import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a
    // nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    
    public int depthSum(List<NestedInteger> nestedIntegers, int depth) {
        int sum = 0;
        for (NestedInteger nestedInteger: nestedIntegers)
            if (nestedInteger.isInteger()) sum += nestedInteger.getInteger() * depth;
            else sum += depthSum(nestedInteger.getList(), depth + 1);
        return sum;
    }
}