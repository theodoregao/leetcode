package leetcode.array.p073;

public class Solution {
    private void setZeroes0(int[][] matrix) {
        int m = matrix.length;
        if (m <= 0) return;
        int n = matrix[0].length;
        
        boolean[] maskRow = new boolean[m];
        boolean[] maskCol = new boolean[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    maskRow[i] = true;
                    maskCol[j] = true;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (maskRow[i] || maskCol[j]) matrix[i][j] = 0;
            }
        }
    }
    
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m <= 0) return;
        int n = matrix[0].length;
        
        boolean c0 = false, r0 = false;
        
        for (int i = 0; i < m; i++) if (matrix[i][n - 1] == 0) c0 = true;
        for (int j = 0; j < n; j++) if (matrix[m - 1][j] == 0) r0 = true;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    matrix[i][n - 1] = 0;
                    matrix[m - 1][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][n - 1] == 0 || matrix[m - 1][j] == 0) matrix[i][j] = 0;
            }
        }

        if (c0) for (int i = 0; i < m; i++) matrix[i][n - 1] = 0;
        if (r0) for (int j = 0; j < n; j++) matrix[m - 1][j] = 0;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0, 2, 5, 2, 2}, {2, 2, 5, 8, 9}, {3, 2, 9, 5, 8}, {8, 6, 9, 8, 9}, {2147483647, 5, 1, 6, 1}};
        new Solution().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}