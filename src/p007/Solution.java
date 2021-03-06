package p007;

import java.util.Stack;

public class Solution {
    
    public int reverse_stack(int xx) {
        long x = xx;
        int sign = x < 0 ? -1 : 1;
        x *= sign;
        
        Stack<Long> stack = new Stack<>();
        while (x != 0) {
            stack.push(x % 10);
            x /= 10;
        }
        
        while (!stack.isEmpty() && stack.peek() == 0) stack.pop();
        
        Stack<Long> otherStack = new Stack<>();
        while (!stack.isEmpty()) otherStack.push(stack.pop());
        
        long v = 0;
        while (!otherStack.isEmpty()) {
            v = v * 10 + otherStack.pop();
            if (v > Integer.MAX_VALUE) return 0;
        }
        
        return (int) (sign * v);
    }
    
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) return 0;
            x /= 10;
        }
        return (int) rev;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1234567899));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
        System.out.println(new Solution().reverse(-1230));
    }
    
}