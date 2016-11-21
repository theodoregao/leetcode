package p073;

public class Solution {
    public void setZeroes(int[][] matrix) {
        
        int row0 = -1, col0 = -1;
        
        for (int i = 0; i < matrix.length && row0 == -1; i++)
            for (int j = 0; j < matrix[0].length && col0 == -1; j++)
                if (matrix[i][j] == 0) {row0 = i; col0 = j;}
        
        if (row0 == -1) return;
        
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] == 0) matrix[i][col0] = matrix[row0][j] = 0;
        
//        System.out.println(row0 + ", " + col0);
//        print(matrix);
        
        for (int i = 0; i < matrix.length; i++) {
            if (i == row0) continue;
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == col0) continue;
                if (matrix[row0][j] == 0 || matrix[i][col0] == 0) matrix[i][j] = 0;
            }
        }
        
//        print(matrix);
        
        for (int i = 0; i < matrix.length; i++) matrix[i][col0] = 0;
        for (int j = 0; j < matrix[0].length; j++) matrix[row0][j] = 0;
    }
    
    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 0}, {1, 1}};
        new Solution().setZeroes(matrix);
//        print(matrix);
    }
}