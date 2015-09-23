package leetcode.facebook067;

import java.util.Stack;

public class Solution {
    
    int values(Character c) {
        return c == '1' ? 1 : 0;
    }
    
    public String addBinary(String a, String b) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s = new Stack<Integer>();

        for (Character c: a.toCharArray()) s1.push(values(c));
        for (Character c: b.toCharArray()) s2.push(values(c));
        
        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            carry += s1.pop() + s2.pop();
            s.push(carry % 2);
            carry /= 2;
        }
        
        while (!s1.isEmpty()) {
            carry += s1.pop();
            s.push(carry % 2);
            carry /= 2;
        }
        
        while (!s2.isEmpty()) {
            carry += s2.pop();
            s.push(carry % 2);
            carry /= 2;
        }
        
        if (carry != 0) s.push(carry);
        
        StringBuffer sb = new StringBuffer();
        while (!s.isEmpty()) sb.append(s.pop());
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("10011", "1101"));
    }
}