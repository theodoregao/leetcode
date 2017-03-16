package p531;

public class Solution {
    private static int[][] DIR = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0) return 0;
        
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        
        for (int i = 0; i < picture.length; i++)
            for (int j = 0; j < picture[i].length; j++)
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
        
        int n = 0;
        for (int i = 0; i < picture.length; i++)
            for (int j = 0; j < picture[i].length; j++)
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1)
                    n++;
        return n;
    }
}