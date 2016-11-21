package p395;

public class Solution {
    
    public int longestSubstringDP(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        
        int longest = 0;
        int[][] counts = new int[n][26];
        int[][] preCounts = new int[n][26];
        
        for (int i = 0; i < n; i++) counts[i][s.charAt(i) - 'a']++;
        
        for (int len = 2; len <= n; len++) {
            int[][] temp = merge(counts, preCounts);
            preCounts = counts;
            counts = temp;
            for (int i = len - 1; i < n; i++) if (checkLeast(counts[i]) >= k) longest = Math.max(longest, len);
        }
        return longest;
    }
    
    private int checkLeast(int[] counts) {
        int least = Integer.MAX_VALUE;
        for (int i = 0; i < counts.length; i++) if (counts[i] > 0 && counts[i] < least) least = counts[i];
        return least;
    }
    
    private int[][] merge(int[][] counts, int[][] preCount) {
        int[][] temp = new int[counts.length][26];
        for (int i = 1; i < counts.length; i++)
            for (int k = 0; k < 26; k++)
                temp[i][k] = counts[i - 1][k] + counts[i][k] - preCount[i - 1][k];
        return temp;
    }
    
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20000; i++) sb.append('a');
        System.out.println(new Solution().longestSubstring(sb.toString(), 1));
        System.out.println(new Solution().longestSubstring("ababbc", 2));
        System.out.println(new Solution().longestSubstring("abcdedghijklmnopqrstuvwxyz", 2));
        System.out.println(new Solution().longestSubstring("abcdefghijklmno", 2));
    }
    
    public int longestSubstring(String s, int k) {
        return recursive(s.toCharArray(), 0, s.length() - 1, k);
    }
    
    public int recursive(char[] str, int lo, int hi, int k) {
        if (hi - lo + 1 < k) return 0;
        
        int[] counts = new int[26];
        for (int i = lo; i <= hi; i++) counts[str[i] - 'a']++;
        
        for (int i = lo; i <= hi; i++) if (counts[str[i] - 'a'] < k) {
            return Math.max(recursive(str, lo, i - 1, k), recursive(str, i + 1, hi, k));
        }
        
        return hi - lo + 1;
    }
    
}