package p316;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        for (char ch: s.toCharArray()) counts[ch - 'a']++;
        Stack<Character> stack = new Stack<Character>();
        for (char ch: s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() < ch && !stack.contains(ch)) stack.push(ch);
            else if (!stack.contains(ch) && stack.peek() >= ch) {
                while (!stack.isEmpty() && stack.peek() >= ch && counts[stack.peek() - 'a'] > 0) stack.pop();
                stack.push(ch);
            }
            counts[ch - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (Character ch: stack) sb.append(ch);
        return sb.toString();
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Solution().removeDuplicateLetters("ccacbaba"));
    }
}