package p128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) set.add(n);
        
        int max = 0;
        for (int n: nums) {
        	if (set.contains(n)) {
        		int l = n, r = n;
        		set.remove(n);
        		while (set.contains(l - 1)) set.remove(--l);
        		while (set.contains(r + 1)) set.remove(++r);
        		max = Math.max(max, r - l + 1);
        	}
        }
        return max;
    }
}