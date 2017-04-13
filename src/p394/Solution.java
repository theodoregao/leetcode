package p394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Object> operands = new Stack<>();
        
        operands.push("");
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (Character.isDigit(str[i])) {
                int j = i;
                while (++j < str.length && Character.isDigit(str[j])) ;
                if (i > 1 && str[i - 1] != '[') operators.push('+');
                operators.push('x');
                operands.push(Integer.parseInt(new String(str, i, j - i)));
                i = j - 1;
            }
            else if (Character.isAlphabetic(str[i])) {
                int j = i;
                while (++j < str.length && Character.isAlphabetic(str[j])) ;
                operands.push(new String(str, i, j - i));
                if (i > 0 && str[i - 1] != '[') operators.add('+');
                i = j - 1;
            }
            else if (str[i] == ']') {
                boolean find = false;
                while (!find) {
                    switch (operators.pop()) {
                        case '+':
                            operands.push(plus((String)operands.pop(), (String)operands.pop()));
                            break;
                            
                        case 'x':
                            operands.push(multiple((String)operands.pop(), (int)operands.pop()));
                            find = true;
                            break;
                            
                        default:
                            break;
                    }
                }
            }
        }
        while (operands.size() > 1) operands.push(plus((String)operands.pop(), (String)operands.pop()));
        return (String) operands.pop();
    }
    
    private String multiple(String s, int n) {
        String r = "";
        for (int i = 0; i < n; i++) r += s;
        return r;
    }
    
    private String plus(String a, String b) {
        return b + a;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString(""));
        System.out.println(new Solution().decodeString("abc"));
        System.out.println(new Solution().decodeString("2[2[b]]"));
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc3[cd]e]f"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}