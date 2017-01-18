package p008;
public class Solution {
    public int myAtoi(String str) {
        Boolean flag = null;
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == '-') {
                if (flag != null) return 0;
                flag = true;
                chars[i] = '0';
            }
            else if (ch == '+') {
                if (flag != null) return 0;
                flag = false;
                chars[i] = '0';
            }
        }
        flag = flag != null && flag == true;
        str = new String(chars).trim();
        long value = 0;
        for (char c: str.toCharArray())
            if (Character.isDigit(c)) {
                value = value * 10 + (c - '0');
                if (value > Integer.MAX_VALUE)
                    return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            else break;
        
        if (flag) value = -value;
        
        if (value <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (value >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int) value;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("+-2"));
        System.out.println(new Solution().myAtoi("  -0012a42"));
        System.out.println(new Solution().myAtoi("   - 321"));
        System.out.println(new Solution().myAtoi("9223372036854775809"));
    }
}