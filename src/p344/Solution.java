package p344;
public class Solution {
    public String reverseString(String s) {
        char[] str = s.toCharArray();
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) swap(str, lo++, hi--);
        return new String(str);
    }
    
    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}