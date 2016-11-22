package p074;

import java.util.Arrays;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] col = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) col[i] = matrix[i][0];
        int pos = Arrays.binarySearch(col, target);
        if (pos >= 0) return true;
        pos = -pos - 2;
        if (pos == -1 || pos >= matrix.length) return false;
        pos = Arrays.binarySearch(matrix[pos], target);
        return pos >= 0;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        
        for (int i = 0; i < 55; i++)
            System.out.println(i + " " + new Solution().searchMatrix(matrix, i));
    }
}