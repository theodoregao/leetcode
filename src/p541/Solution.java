package p541;
public class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] str = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k)
            reverse(str, i, Math.min(n - 1, i + k - 1));
        return new String(str);
    }
    
    private void reverse(char[] str, int lo, int hi) {
        while (lo < hi) swap(str, lo++, hi--);
    }
    
    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}