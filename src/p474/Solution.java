package p474;

public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        for (String s : strs) {
            int ones = 0, zeros = 0;
            for (char c: s.toCharArray()) if (c == '0') zeros++; else ones++;
            for (int i = m; i >= zeros; i--) for (int j = n; j >= ones; j--)
                dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        }
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxForm(new String[] {"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0","0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"}, 9, 80));
        System.out.println(new Solution().findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(new Solution().findMaxForm(new String[] {"10", "0", "1"}, 1, 1));
    }
}