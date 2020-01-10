package pp1209;

import java.util.Stack;

class Solution { 
    
    class CharacterCount {
        char ch;
        int count;
        
        CharacterCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<CharacterCount> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().ch != ch) {
                stack.push(new CharacterCount(ch, 1));
            } else {
               if (stack.peek().count + 1 < k) {
                   CharacterCount cc = stack.pop();
                   stack.push(new CharacterCount(cc.ch, cc.count + 1));
               } else {
                   stack.pop();
               }
            }
        }
        
        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            CharacterCount cc = stack.pop();
            for (int i = 0; i < cc.count; i++) {
                sb.append(cc.ch);
            }
        }
        return sb.reverse().toString();
    }
}
