package p341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	private Iterator<Integer> it;
	
    public NestedIterator(List<NestedInteger> nestedList) {
    	List<Integer> values = new ArrayList<>();
        travel(values, nestedList);
        it = values.iterator();
    }
    
    private void travel(List<Integer> values,List<NestedInteger> list) {
    	for (NestedInteger ni: list)
    		if (ni.isInteger()) values.add(ni.getInteger());
    		else travel(values, ni.getList());
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

	public void remove() {
		// TODO Auto-generated method stub
		
	}
}

/**
Your NestedIterator object will be instantiated and called as such:
NestedIterator i = new NestedIterator(nestedList);
while (i.hasNext()) v[f()] = i.next();
 */