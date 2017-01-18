package p072;
public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] count = new int[n + 1];
        int[] temp = new int[n + 1];
        for (int i = 0; i <= n; i++) count[i] = i;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) temp[j] = count[j];
            count[0] = i;
            for (int j = 1; j <= n; j++) {
                int left = count[j - 1] + 1;
                int top = temp[j] + 1;
                int cross = (word1.charAt(j - 1) == word2.charAt(i - 1) ? 0 : 1) + temp[j - 1];
                count[j] = Math.min(left, Math.min(top, cross));
            }
        }
        
        return count[n];
    }
}