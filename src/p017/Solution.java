package p017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    private static Map<Character, Character[]> map = new HashMap<>();
    
    static {
        map.put('2', new Character[] {'a', 'b', 'c'});
        map.put('3', new Character[] {'d', 'e', 'f'});
        map.put('4', new Character[] {'g', 'h', 'i'});
        map.put('5', new Character[] {'j', 'k', 'l'});
        map.put('6', new Character[] {'m', 'n', 'o'});
        map.put('7', new Character[] {'p', 'q', 'r', 's'});
        map.put('8', new Character[] {'t', 'u', 'v'});
        map.put('9', new Character[] {'w', 'x', 'y', 'z'});
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() > 0) recursive(list, "", digits, 0);
        return list;
    }
    
    private void recursive(List<String> results, String result, String digits, int pos) {
        if (pos == digits.length()) {
            results.add(result);
            return;
        }
        for (Character c: map.get(digits.charAt(pos))) {
            result += c;
            recursive(results, result, digits, pos + 1);
            result = result.substring(0, result.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        for (String string: new Solution().letterCombinations(""))
            System.out.println(string);
    }
}