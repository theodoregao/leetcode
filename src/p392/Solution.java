package p392;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    public boolean isSubsequenceBruteForce(String s, String t) {
        int i = 0, j = 0;
        for (; i < t.length() && j < s.length(); i++) {
            if (s.charAt(j) == t.charAt(i)) j++;
        }
        return j == s.length();
    }
    
    private String t;
    private Map<Character, Integer[]> map; 
    
    public boolean isSubsequence(String s, String t) {
        if (this.t == null) {
            this.t = t;
            
            Map<Character, List<Integer>> tempMap = new HashMap<>();
            for (Character c = 'a'; c <= 'z'; c++) tempMap.put(c, new ArrayList<Integer>());
            
            for (int i = 0; i < t.length(); i++) tempMap.get(t.charAt(i)).add(i);
            
            map = new HashMap<>();
            for (Character c = 'a'; c <= 'z'; c++) {
                List<Integer> list = tempMap.get(c);
                Integer[] array = new Integer[list.size()];
                for (int i = 0; i < list.size(); i++) array[i] = list.get(i);
                map.put(c, array);
            }
        }
        
        int i = 0, j = 0;
        for (; i < t.length() && j < s.length(); ) {
            Integer[] indices = map.get(s.charAt(j));
            int pos = Arrays.binarySearch(indices, i);
            if (pos >= 0) {
                i++; j++;
            }
            else {
                pos = -1 - pos;
                if (pos < indices.length) {
                    i = indices[pos];
                }
                else return false;
            }
        }
        
        return j == s.length();
        
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
    }
    
}