package p562;
public class Solution {
    public int longestLine(int[][] M) {
        int m = M.length;
        if (m == 0) return 0;
        int n = M[0].length;
        if (n == 0) return 0;
        int max = 0;
        int k = 0;
        int currentMax;
        
        for (int i = 0; i < m; i++) {
            currentMax = k = 0;
            for (int j = 0; j < n; j++) {
                k = M[i][j] == 1 ? k + 1 : 0;
                currentMax = Math.max(currentMax, k);
            }
            max = Math.max(currentMax, max);
        }
        
        for (int j = 0; j < n; j++) {
            currentMax = k = 0;
            for (int i = 0; i < m; i++) {
                k = M[i][j] == 1 ? k + 1 : 0;
                currentMax = Math.max(currentMax, k);
            }
            max = Math.max(currentMax, max);
        }
        
        for (int i = 0; i < m; i++) {
            currentMax = k = 0;
            for (int j = 0; i + j < m && j < n; j++) {
                k = M[i + j][j] == 1 ? k + 1 : 0;
                currentMax = Math.max(currentMax, k);
            }
            max = Math.max(currentMax, max);
        }
        
        for (int j = 0; j < n; j++) {
            currentMax = k = 0;
            for (int i = 0; i < m && i + j < n; i++) {
                k = M[i][i + j] == 1 ? k + 1 : 0;
                currentMax = Math.max(currentMax, k);
            }
            max = Math.max(currentMax, max);
        }
        
        for (int i = 0; i < m; i++) {
            currentMax = k = 0;
            for (int j = 0; i - j >= 0 && j < n; j++) {
                k = M[i - j][j] == 1 ? k + 1 : 0;
                currentMax = Math.max(currentMax, k);
            }
            max = Math.max(currentMax, max);
        }
        
        for (int j = 0; j < n; j++) {
            currentMax = k = 0;
            for (int i = 0; i < m && i + j < n; i++) {
                k = M[m - i - 1][i + j] == 1 ? k + 1 : 0;
                currentMax = Math.max(currentMax, k);
            }
            max = Math.max(currentMax, max);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestLine(new int[][] {
                {0,1,1,0},{0,1,1,0},{1,0,0,0}
        }));
    }
}