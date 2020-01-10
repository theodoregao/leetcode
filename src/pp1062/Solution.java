package pp1062;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    
    private boolean checkRepeatingSubstring(final String s, final int length) {
        final HashMap<Integer, Set<String>> map = new HashMap<>();
        for (int i = 0; i <= s.length() - length; i++) {
            final String subString = s.substring(i, i + length);
            final int hash = subString.hashCode();
            if (map.containsKey(hash) && map.get(hash).contains(subString)) {
                return true;
            } else {
                if (!map.containsKey(hash)) {
                    map.put(hash, new HashSet<>());
                }
                map.get(hash).add(subString);
            }
        }
        return false;
    }
    
    private int longestRepeatingSubstring(String S, int low, int high) {
        if (low >= high) {
            return checkRepeatingSubstring(S, low) ? low : 0;
        }
        final int mid = (low + high + 1) >> 1;
        if (checkRepeatingSubstring(S, mid)) {
            return Math.max(mid, longestRepeatingSubstring(S, mid + 1, high));
        } else {
            return longestRepeatingSubstring(S, low, mid - 1);
        }
    }
    
    public int longestRepeatingSubstring(String S) {
        return longestRepeatingSubstring(S, 0, S.length() - 1);
    }
}
