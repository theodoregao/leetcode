package leetcode.array.p062;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m + 1][n + 1];
        
        paths[m][n - 1] = 1;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                paths[i][j] = paths[i + 1][j] + paths[i][j + 1];
            }
        }
        
        return paths[0][0];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(2, 2));
        System.out.println(new Solution().uniquePaths(1, 20));
        System.out.println(new Solution().uniquePaths(20, 1));
        System.out.println(new Solution().uniquePaths(2, 3));
        System.out.println(new Solution().uniquePaths(3, 2));
        System.out.println(new Solution().uniquePaths(3, 3));
    }
}