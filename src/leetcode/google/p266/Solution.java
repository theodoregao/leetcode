package leetcode.google.p266;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Theodore
 *
 *  是否区分大小写，是否有非字母字符
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) map.put(chars[i], map.get(chars[i]) + 1);
            else map.put(chars[i], 1);
        }
        
        int oddCount = 0;
        for (Integer count: map.values()) {
            if (count % 2 != 0) oddCount++;
        }
        
        return oddCount < 2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canPermutePalindrome("AaBb//a"));
    }
}