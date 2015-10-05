package leetcode.array.p059;

public class Solution {
    private static final int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;
        
        int dir = 0;
        int i = 0, j = -1;
        int ni, nj;
        int k = 0;
        int sz = n * n;
        
        while (true) {
            ni = i + DIRS[dir][0];
            nj = j + DIRS[dir][1];
            
            if (ni < 0 || ni >= n || nj < 0 || nj >= n || matrix[ni][nj] != 0) {
                dir = (dir + 1) % DIRS.length;
            }
            else {
                i = ni;
                j = nj;
                matrix[i][j] = ++k;
                if (k >= sz) break;
            }
            
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(0);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}