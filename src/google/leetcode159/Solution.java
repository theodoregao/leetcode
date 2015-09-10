package google.leetcode159;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Theodore
 *
 *  HashMap，双指针。注意考虑大小写属于不同情况
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() <= 2) return s.length();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        int ps = 0;
        int count = 0;
        char ch;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (map.get(ch) == null) map.put(ch, 0);
            map.put(ch, map.get(ch) + 1);
            if (map.get(ch) == 1)
                count++;
            while (count > 2) {
                map.put(s.charAt(ps), map.get(s.charAt(ps)) - 1);
                if (map.get(s.charAt(ps)) == 0) count--;
                ps++;
            }
            length = Math.max(length, i - ps + 1);
        }
        
        return length;
    }
}