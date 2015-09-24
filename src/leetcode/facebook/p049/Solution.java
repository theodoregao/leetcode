package leetcode.facebook.p049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<String>());
            }
            
            map.get(sortedStr).add(str);
        }
        
        for (List<String> list: map.values()) {
            Collections.sort(list);
        }
        
        return new ArrayList<List<String>>(map.values());
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}