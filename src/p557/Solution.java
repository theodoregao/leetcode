package p557;
public class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = 0;
        for (i = 0; i < str.length; i++) {
            if (str[i] != ' ') for (j = i; j <= str.length; j++)
                if (j == str.length || str[j] == ' ') {
                    reverse(str, i, j - 1);
                    i = j + 1;
                }
        }
        return new String(str);
    }
    
    private void reverse(char[] str, int lo, int hi) {
        while (lo < hi) swap(str, lo++, hi--);
    }
    
    private void swap(char[] str, int i, int j) {
        char c = str[i];
        str[i] = str[j];
        str[j] = c;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Let's take LeetCode contest"));
    }
}