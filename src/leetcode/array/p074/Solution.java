package leetcode.array.p074;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m < 1) return false;
        int n = matrix[0].length;
        
        int left = 0;
        int right = m * n - 1;
        int mid;
        int value;
        
        while (left <= right) {
            mid = (left + right) >>> 1;
            value = getValue(matrix, mid);
            if (value < target) left = mid + 1;
            else if (value > target) right = mid - 1;
            else return true;
        }
        return false;
    }
    
    private int getValue(int[][] matrix, int pos) {
        return matrix[pos / matrix[0].length][pos % matrix[0].length];
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(new Solution().searchMatrix(matrix, 4));
    }
}