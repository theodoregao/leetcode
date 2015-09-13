package google.leetcode020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (map.values().contains(ch)) stack.push(ch);
            else if (!stack.isEmpty() && stack.peek() == map.get(ch)) stack.pop();
            else return false;
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[{}]"));
        System.out.println(new Solution().isValid("()[}{]"));
        System.out.println(new Solution().isValid("]"));
        System.out.println(new Solution().isValid("()[{}"));
    }
}