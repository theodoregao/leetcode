package leetcode.facebook.p221;

public class Solution {
    
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        
        int maxSize = 0;
        int sz;
        int k;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sz = dp[i - 1][j - 1];
                k = 0;
                for (; k <= sz; k++) if (matrix[i - k - 1][j - 1] == '0' || matrix[i - 1][j - k - 1] == '0') break;
                dp[i][j] = k;
                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }
        return maxSize * maxSize;
    }
    
    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'0', '0', '1', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'},
                {'1', '1', '0', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'},
        };
        System.out.println(new Solution().maximalSquare(matrix));
    }
}