package p331;

import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] tokens = preorder.split(",");
        for (String token: tokens) {
//            System.out.println(token);
            if (token.equals("#")) {
                if (stack.size() == 0) stack.push(token);
                else if (!stack.peek().equals("#")) stack.push("#");
                else if (stack.peek().equals("#")) {
                    while (stack.size() > 0 && stack.peek().equals("#")) {
                        stack.pop();
                        if (stack.size() == 0) return false;
                        stack.pop();
//                        System.out.println(stack);
                    }
                    stack.push("#");
                }
            }
                
            else {
                stack.push(token);
//                System.out.println(stack);
            }
        }
//        System.out.println(stack);
        return stack.size() == 1 && stack.peek().equals("#");
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution().isValidSerialization("1,#"));
        System.out.println(new Solution().isValidSerialization("9,#,#,1"));
        System.out.println(new Solution().isValidSerialization("#"));
        System.out.println(new Solution().isValidSerialization(""));
        System.out.println(new Solution().isValidSerialization("#,#,#"));
        System.out.println(new Solution().isValidSerialization("#,#"));
        System.out.println(new Solution().isValidSerialization("#,#,#,#"));
    } 
}