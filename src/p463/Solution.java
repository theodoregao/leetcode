package p463;
public class Solution {
    
    private static int[][] DIR = new int[][] {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 1) for (int k = 0; k < DIR.length; k++){
                    int y = i + DIR[k][0];
                    int x = j + DIR[k][1];
                    if (y < 0 || x < 0 || y >= r || x >= c) count++;
                    else if (grid[y][x] != 1) count++;
                }
            }
        return count;
    }
    
}