package p421;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findMaximumXOR(int[] nums) {
    	int max = 0, mask = 0;
    	for (int i = 31; i >= 0; i--) {
    		mask |= (1 << i);
    		Set<Integer> set = new HashSet<>();
    		for (int n: nums) set.add(n & mask);
    		int tmp = max | (1 << i);
    		for (int prefix: set) if (set.contains(tmp ^ prefix)) max = tmp;
    	}
    	return max;
    }
    
    // try to use TRIE to solve this problem
    // try to use divide and conquer to solve this problem
}