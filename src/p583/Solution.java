package p583;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 && word2.length() == 0) return 0;
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1][l2];
        for (int i = 0; i < l1; i++) for (int j = 0; j < l2; j++) dp[i][j] = Integer.MAX_VALUE;
        return recursive(dp, word1, l1 - 1, word2, l2 - 1);
    }
    
    private int recursive(int[][] dp, String s1, int hi1, String s2, int hi2) {
        if (hi1 < 0 || hi2 < 0) return Math.max(hi1, hi2) + 1;
        if (dp[hi1][hi2] != Integer.MAX_VALUE) return dp[hi1][hi2];
        dp[hi1][hi2] = Math.min(dp[hi1][hi2], (s1.charAt(hi1) == s2.charAt(hi2) ? 0 : 2) + recursive(dp, s1, hi1 - 1, s2, hi2 - 1));
        dp[hi1][hi2] = Math.min(dp[hi1][hi2], 1 + recursive(dp, s1, hi1 - 1, s2, hi2));
        dp[hi1][hi2] = Math.min(dp[hi1][hi2], 1 + recursive(dp, s1, hi1, s2, hi2 - 1));
        return dp[hi1][hi2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("", ""));
        System.out.println(new Solution().minDistance("", "eat"));
        System.out.println(new Solution().minDistance("ate", ""));
        System.out.println(new Solution().minDistance("ate", "eat"));
        System.out.println(new Solution().minDistance("old", "ordinary"));
    }
}