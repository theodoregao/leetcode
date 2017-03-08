package p205;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else if (map.values().contains(t.charAt(i))) return false;
            else map.put(s.charAt(i), t.charAt(i));
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("ab", "aa"));
        System.out.println(new Solution().isIsomorphic("paper", "title"));
        System.out.println(new Solution().isIsomorphic("egg", "add"));
        System.out.println(new Solution().isIsomorphic("foo", "bar"));
    }
}