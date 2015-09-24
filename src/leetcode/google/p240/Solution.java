package leetcode.google.p240;
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean searchMatrix(int[][] matrix, int target, int up, int down, int left, int right) {
        if (left > right || up > down) return false;
        
        int x = (left + right) / 2;
        int y = (up + down) / 2;
        
        int value = matrix[y][x];
        
        if (target == value) return true;
        
        else if (target < value)
            return searchMatrix(matrix, target, up, y - 1, left, x - 1)
                    || searchMatrix(matrix, target, y, down, left, x - 1)
                    || searchMatrix(matrix, target, up, y - 1, x, right);
        
        else return searchMatrix(matrix, target, y + 1, down, left, x)
                || searchMatrix(matrix, target, up, y, x + 1, right)
                || searchMatrix(matrix, target, y + 1, down, x + 1, right);
    }
    
//    public static void main(String[] args) {
//        int[][] matrix = new int[][] {
//                 {1,   4,  7, 11, 15},
//                 {2,   5,  8, 12, 19},
//                 {3,   6,  9, 16, 22},
//                 {10, 13, 14, 17, 24},
//                 {18, 21, 23, 26, 30}
//            };
//        
//        for (int i = 1; i <= 30; i++) {
//            System.out.println(i + " : " + new Solution().searchMatrix(matrix, i));
//        }
//    }
}