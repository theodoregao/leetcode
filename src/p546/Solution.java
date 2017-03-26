package p546;
public class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return solve(dp, boxes, 0, boxes.length - 1, 0);
    }
    
    private int solve(int[][][] dp, int[] boxes, int lo, int hi, int level) {
        if (lo > hi) return 0;
        if (dp[lo][hi][level] != 0) return dp[lo][hi][level];
        dp[lo][hi][level] = solve(dp, boxes, lo, hi - 1, 0) + (level + 1) * (level + 1);
        for (int i = hi - 1; i >= lo; i--)
            if (boxes[i] == boxes[hi])
                dp[lo][hi][level] = Math.max(dp[lo][hi][level],
                        solve(dp, boxes, lo, i, level + 1) + solve(dp, boxes, i + 1, hi - 1, 0));
        return dp[lo][hi][level];
    }
}