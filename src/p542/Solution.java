package p542;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    
    private static int[][] DIR = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        List<List<Integer>> list = new ArrayList<>();
        int m = matrix.size();
        int n = matrix.get(0).size();
        int[][] mat = new int[m][n];
        int[][] distance = new int[m][n];
        Queue<Location> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            mat[i][j] = matrix.get(i).get(j);
            distance[i][j] = mat[i][j] == 0 ? 0 : Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) {
            if (mat[i][j] == 0) for (int d = 0; d < DIR.length; d++) {
                int r = i + DIR[d][0];
                int c = j + DIR[d][1];
                if (valid(mat, r, c) && distance[r][c] > 0) {
                    queue.offer(new Location(r, c));
                    distance[r][c] = 1;
                }
            }
        }
        while (!queue.isEmpty()) {
            Location l = queue.poll();
            for (int d = 0; d < DIR.length; d++) {
                int r = l.r + DIR[d][0];
                int c = l.c + DIR[d][1];
                if (valid(mat, r, c) && distance[l.r][l.c] + 1 < distance[r][c]) {
                    queue.offer(new Location(r, c));
                    distance[r][c] = distance[l.r][l.c] + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++) l.add(distance[i][j]);
            list.add(l);
        }
        return list;
    }
    
    private boolean valid(int[][] mat, int r, int c) {
        return r >= 0 && c >= 0 && r < mat.length && c < mat[0].length;
    }
    
    private static class Location {
        int r;
        int c;
        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}