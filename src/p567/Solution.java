package p567;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()) if (map.containsKey(c)) map.put(c, map.get(c) + 1); else map.put(c, 1);
        int n = s1.length();
        char[] chars = s2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
//            System.out.println("handle " + chars[i]);
//            System.out.println(map);
            if (i >= n) {
                char cs = chars[i - n];
                if (!map.containsKey(cs)) map.put(cs, 1);
                else {
                    if (map.get(cs) == -1) map.remove(cs);
                    else map.put(cs, map.get(cs) + 1);
                }
            }
//            System.out.println(map);
            char c = chars[i];
            if (!map.containsKey(c)) map.put(c, -1);
            else {
                if (map.get(c) == 1) {
                    map.remove(c);
                    if (map.isEmpty()) return true;
                }
                else map.put(c, map.get(c) - 1);
            }
//            System.out.println("after handle " + chars[i]);
//            System.out.println(map);
//            System.out.println();
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("hello", "ooolleoooleh"));
        System.out.println(new Solution().checkInclusion("hello", "ooolleohooleh"));
        System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));
        System.out.println(new Solution().checkInclusion("ab", "eidboaooo"));
        System.out.println(new Solution().checkInclusion("adc", "dcda"));
        System.out.println(new Solution().checkInclusion("aaa", "aadaaeaasaacaaadfer"));
    }
}