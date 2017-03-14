package p378;
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        long lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        while (lo <= hi) {
            long mid = (lo + hi) >> 1;
            int count = count(matrix, mid);
            if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return (int) lo;
    }
    
    private int count(int[][] matrix, long v) {
        int count = 0;
        for (int i = matrix.length - 1, j = 0; i >= 0 && j < matrix.length; ) {
            if (matrix[i][j] > v) i--;
            else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(new int[][] {{2000000000}}, 1));
    }
}