package p221;
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) return 0;
        int m = matrix[0].length;
        int[] counts = new int[m + 1];
        int[] temp = new int[m + 1];
        
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) temp[j] = counts[j];
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    counts[j] = min(temp[j - 1], temp[j], counts[j - 1]) + 1;
                    maxSize = Math.max(maxSize, counts[j]);
                } else counts[j] = 0;
            }
        }
        return maxSize * maxSize;
    }
    
    private int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}