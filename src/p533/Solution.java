package p533;
public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        if (picture.length == 0) return 0;
        
        int[] row = new int[picture.length];
        int[] col = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++)
            for (int j = 0; j < picture[0].length; j++)
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
        
        int n = 0;
        for (int i = 0; i < picture.length; i++)
            for (int j = 0; j < picture[0].length; j++)
                if (row[i] == N && col[j] == N && check(picture, i, j))
                    n++;
        return n;
    }
    
    private boolean check(char[][] picture, int ii, int jj) {
        System.out.println("check " + ii);
        for (int i = 0; i < picture.length; i++)
            for (int j = 0; j < picture[0].length; j++)
                if (picture[ii][j] == 'B' && picture[i][jj] == 'B')
                    if (picture[i][j] != 'B') {
                        return false;
                    }
        return true;
    }
}