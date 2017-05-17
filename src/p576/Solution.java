package p576;
public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        final long SIZE = 1000000007;
        final int[][] DIR = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
        long count = 0L;
        long[][] map = new long[m][n];
        long[][] next = new long[m][n];
        long[][] temp;
        map[i][j] = 1;
        while (N-- > 0) {
            for (int ii = 0; ii < m; ii++) {
                count = (count + map[ii][0]) % SIZE;
                count = (count + map[ii][n - 1]) % SIZE;
            }
            for (int jj = 0; jj < n; jj++) {
                count = (count + map[0][jj]) % SIZE;
                count = (count + map[m - 1][jj]) % SIZE;
            }
            for (int ii = 0; ii < m; ii++) for (int jj = 0; jj < n; jj++) next[ii][jj] = 0;
            for (int ii = 0; ii < m; ii++) for (int jj = 0; jj < n; jj++) {
                for (int k = 0; k < DIR.length; k++) {
                    int iii = ii + DIR[k][0];
                    int jjj = jj + DIR[k][1];
                    if (iii >= 0 && jjj >= 0 && iii < m && jjj < n) next[iii][jjj] = (next[iii][jjj] + map[ii][jj]) % SIZE;
                }
            }
            temp = map;
            map = next;
            next = temp;
        }
        return (int) (count % SIZE);
    }
}