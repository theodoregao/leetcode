package p516;
public class Solution {
    public int longestPalindromeSubseq(String s) {
    	if (s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        return recursive(dp, s, 0, s.length() - 1);
    }
    
    private int recursive(int[][] dp, String s, int lo, int hi) {
    	if (lo == hi) return 1;
    	else if (dp[lo][hi] != 0) return dp[lo][hi];
    	else if (s.charAt(lo) == s.charAt(hi))
    		if (lo + 1 == hi) return dp[lo][hi] = 2;
    		else return dp[lo][hi] = 2 + recursive(dp, s, lo + 1, hi - 1);
    	else return dp[lo][hi] = Math.max(recursive(dp, s, lo + 1, hi), recursive(dp, s, lo, hi - 1));
    }
}