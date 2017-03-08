package p054;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private int[][] DIR = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ints = new ArrayList<>();
        if (matrix.length == 0) return ints;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int dir = 0;
        int i = 0, j = 0;

        while (j >= l && j <= r && i >= t && i <= b) {
//            System.out.println(l + ", " + r + ", " + t + ", " + b + ": " + i + ", " + j + ", " + (dir % 4));
//            System.out.println(matrix[i][j]);
            ints.add(matrix[i][j]);
            switch (dir % 4) {
            case 0: if (j == r) { t++; dir++;} break;
            case 1: if (i == b) { r--; dir++;} break;
            case 2: if (j == l) { b--; dir++;} break;
            case 3: if (i == t) { l++; dir++;} break;
            default: break;
            }
            i += DIR[dir % 4][1];
            j += DIR[dir % 4][0];
        }
        return ints;
    }
    
    public static void main(String[] args) {
        new Solution().spiralOrder(new int[][] {{3},{2}});
        new Solution().spiralOrder(new int[][] {{3,2}});
        new Solution().spiralOrder(new int[][] {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}});
        new Solution().spiralOrder(new int[][] {{2,5,8},{4,0,-1}});
    }
}