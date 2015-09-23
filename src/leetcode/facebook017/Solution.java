package leetcode.facebook017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private static Map<Character, String> map;
    
    static {
        map = new HashMap<Character, String>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> results = new ArrayList<String>();
        
        if (digits == null || digits.length() == 0) return results; // 注意输入为空的情况
        
        results.addAll(letterCombinations(Arrays.asList(""), digits));
        
        return results;
    }

    private List<String> letterCombinations(List<String> results, String digits) {
        if (digits.length() == 0) return results;
        
        List<String> list = new ArrayList<String>();
        for (String result: results) {
            for (Character c: map.get(digits.charAt(0)).toCharArray()) {
                list.add(result + c);
            }
        }
        return letterCombinations(list, digits.substring(1));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}