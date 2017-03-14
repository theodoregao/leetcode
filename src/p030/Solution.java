package p030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();
        if (words.length == 0) return indices;
        
        Map<String, Integer> MAP = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            if (!MAP.containsKey(word)) MAP.put(word, 0);
            MAP.put(word, MAP.get(word) + 1);
        }
        
        int length = words[0].length();
        int n = words.length;
        int m = n;
        
        for (int k = 0; k < length; k++) {
            map.clear();
            map.putAll(MAP);
            m = n;
            for (int i = k, j = k; j < s.length() - length + 1; ) {
                String word = s.substring(j, j + length);
                if (map.containsKey(word)) {
                    if (map.get(word) > 0) {
                        map.put(word, map.get(word) - 1);
                        j += length;
                        m--;
                        if (m == 0) indices.add(i);
                    }
                    else {
                        word = s.substring(i, i + length);
                        map.put(word, map.get(word) + 1);
                        i += length;
                        m++;
                    }
                }
                else {
                    j += length;
                    i = j;
                    map.clear();
                    map.putAll(MAP);
                    m = n;
                }
            }
        }
        
        return indices;
    }
    
    public static void main(String[] args) {
        for (int i: new Solution().findSubstring("barfootfofofoobarfoobarmanxxxfoobarfooxxx", new String[] {"foo","bar"})) System.out.println(i);
        for (int i: new Solution().findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"})) System.out.println(i);
    }
}