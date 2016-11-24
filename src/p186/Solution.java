package p186;
public class Solution {
    
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int i, j;
        for (i = 0, j = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, j, i - 1);
                j = i + 1;
            }
        }
        reverse(s, j, i - 1);
    }
    
    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        char[] s = "the sky is blue".toCharArray();
        new Solution().reverseWords(s);
        System.out.println(new String(s));
    }
}