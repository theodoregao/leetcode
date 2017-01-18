package p290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] tokens = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int i = 0;
        for (Character c: pattern.toCharArray()) {
        	if (i >= tokens.length) return false;
        	else if (map.containsKey(c) && !tokens[i].equals(map.get(c))) return false;
        	else {
        		set.add(tokens[i]);
        		map.put(c, tokens[i++]);
        	}
        }
        return set.size() == map.size() && i == tokens.length;
    }
}