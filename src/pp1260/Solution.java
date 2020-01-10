package pp1260;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        final int m = grid.length;
        final int n = grid[0].length;
        final List<List<Integer>> matrix = new ArrayList<>();
        final int count = m * n;
        int index = (-k % count + count - 1) % count;
        for (int i = 0; i < m; i++) {
            final List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                index = ++index % count;
                row.add(grid[index / n][index % n]);
            }
            matrix.add(row);
        }
        return matrix;
    }
}
