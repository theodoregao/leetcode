package google.leetcode246;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Character, Character> MAP;
    static {
        MAP = new HashMap<Character, Character>();
        MAP.put('0', '0');
        MAP.put('1', '1');
        MAP.put('6', '9');
        MAP.put('8', '8');
        MAP.put('9', '6');
    }
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        Character ch;
        for (int i = 0; i < num.length(); i++) {
            ch = MAP.get(num.charAt(i));
            if (ch == null) return false;
            sb.append(ch);
        }
        return sb.reverse().toString().equals(num);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isStrobogrammatic("69"));
        System.out.println(new Solution().isStrobogrammatic("818"));
        System.out.println(new Solution().isStrobogrammatic("88"));
        System.out.println(new Solution().isStrobogrammatic("0081800"));
    }
}