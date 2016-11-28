package p151;
public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();
        reverse(chars, 0, chars.length - 1);
        
        for (int i = 0, j = 0; j <= chars.length; j++) {
            if (j == chars.length || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') sb.append(chars[i]);
            if (chars[i] == ' ' && (sb.length() == 0 || sb.charAt(sb.length() - 1) != ' ')) sb.append(' ');
        }
        
        return sb.toString();
    }
    
    private void reverse(char[] str, int lo, int hi) {
        for (int i = lo, j = hi; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the   sky   is blue"));
        System.out.println(new Solution().reverseWords(" "));
    }
}