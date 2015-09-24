package leetcode.facebook.p091;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    private static Map<String, Integer> map = new HashMap<String, Integer>();
    
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        return dp(s);
    }
    
    private int dp(String s) {
        if (map.containsKey(s)) return map.get(s);
        
        if (s.length() == 0) return 1;
        
        int num = 0;
        
        if (s.length() >= 2 && s.charAt(0) != '0') {
            int code = Integer.parseInt(s.substring(0, 2));
            if (code > 0 && code <= 26) num += dp(s.substring(2));
        }
        
        if (s.length() >= 1) {
            int code = Integer.parseInt(s.substring(0, 1));
            if (code > 0) num += dp(s.substring(1));
        }
        
        map.put(s, num);
        
        return map.get(s);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings(""));
        System.out.println(new Solution().numDecodings("127"));
        System.out.println(new Solution().numDecodings("0127"));
        System.out.println(new Solution().numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }
}