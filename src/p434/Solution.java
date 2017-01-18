package p434;
public class Solution {
    public int countSegments(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) count++;
        return count;
    }
}