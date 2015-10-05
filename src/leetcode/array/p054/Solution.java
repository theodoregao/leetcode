package leetcode.array.p054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length <= 0) return spiral;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        int sz = m * n;
        int dir = 0;
        int i = 0, j = -1;
        int ni, nj;
        
        while (true) {
            ni = i + DIRS[dir][0];
            nj = j + DIRS[dir][1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || visited[ni][nj]) {
                dir = (dir + 1) % DIRS.length;
                continue;
            }
            else {
                i = ni;
                j = nj;
                visited[i][j] = true;
                spiral.add(matrix[i][j]);
                if (--sz <= 0) break;
            }
        }
        
        return spiral;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        for (Integer i: new Solution().spiralOrder(matrix)) System.out.println(i);
    }
}