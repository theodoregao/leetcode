package google.leetcode281;

import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
    
    private Iterator<Integer> it1, it2, it;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        it = it1.hasNext() ? it1 : it2;
    }

    public int next() {
        int val = it.next();
        if (it == it1 && it2.hasNext()) {
            it = it2;
        }
        else if (it == it2 && it1.hasNext()) {
            it = it1;
        }
        return val;
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */