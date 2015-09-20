package leetcode.facebook028;
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) return -1;
        
        int n = haystack.length();
        int m = needle.length();
        char[] str = haystack.toCharArray();
        char[] target = needle.toCharArray();

        int i, j;
        for (i = 0; i <= n - m; i++) {
            for (j = 0; j < m; j++) {
                if (str[i + j] != target[j]) break;
            }
            if (j == m) return i;
        }
        return -1;
    }
}