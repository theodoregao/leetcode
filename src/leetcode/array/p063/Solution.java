package leetcode.array.p063;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        
        int[][] paths = new int[m + 1][n + 1];
        
        paths[m][n - 1] = 1;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
            }
        }
        
        return paths[0][0];
    }
    
    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
    }
}