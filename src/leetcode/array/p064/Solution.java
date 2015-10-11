package leetcode.array.p064;

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return Integer.MAX_VALUE;
        int[][] sum = new int[grid.length + 1][grid[0].length + 1];
        
        for (int i = 2; i <= grid.length; i++) sum[i][0] = Integer.MAX_VALUE;
        for (int i = 2; i <= grid[0].length; i++) sum[0][i] = Integer.MAX_VALUE;
        
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        
        return sum[grid.length][grid[0].length];
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][] {{1, 1, 2, 2}, {2, 1, 10, 2}, {2, 2, 1, 1}, {2, 2, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }
}