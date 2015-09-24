package leetcode.facebook.p076;

import java.util.HashMap;
import java.util.Map;

/**
 * 2 pointers
 *
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c: t.toCharArray()) {
            if (!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c) - 1);
        }
        
        int n = map.keySet().size();
        int left = 0, right = 0, minLeft = 0, minRight = Integer.MAX_VALUE;
        
        char[] str = s.toCharArray();
        char c;
        while (n == 0 || right < str.length) {
            if (n > 0) {
                c = str[right++];
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) == 0) n--;
                }
            }
            if (n == 0) {
                if ((right - left) < (minRight - minLeft)) {
                    minLeft = left;
                    minRight = right;
                }
                c = str[left++];
                if (map.containsKey(c)) {
                    if (map.get(c) == 0) n++;
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        
        if (minRight <= s.length())
            return s.substring(minLeft, minRight);
        else return "";
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("aa", "aa"));
        System.out.println(new Solution().minWindow("a", "aa"));
    }
}