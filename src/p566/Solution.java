package p566;
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r * c != nums.length * nums[0].length) return nums;
        int[][] rst = new int[r][c];
        int n = 0;
        int col = nums[0].length;
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) {
            rst[i][j] = nums[n / col][n % col];
            n++;
        }
        return rst;
    }
}