package p305;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private static int[][] DIR = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    
    public List<Integer> numIslands2(int row, int col, int[][] positions) {
        UnionFind unionFind = new UnionFind(row, col);
        boolean[] fields = new boolean[row * col];
        List<Integer> lands = new ArrayList<>();
        int nWater = row * col;
        for (int k = 0; k < positions.length; k++) {
            int r = positions[k][0];
            int c = positions[k][1];
            if (!fields[index(col, r, c)]) {
                fields[index(col, r, c)] = true;
                nWater--;
                for (int i = 0; i < DIR.length; i++) {
                    int rr = r + DIR[i][0];
                    int cc = c + DIR[i][1];
                    if (valid(row, col, rr, cc) && fields[index(col, rr, cc)])
                        unionFind.union(index(col, r, c), index(col, rr, cc));
                }
            }
            lands.add(unionFind.count() - nWater);
        }
        return lands;
    }
    
    private boolean valid(int row, int col, int r, int c) {
        return r >= 0 && c >= 0 && r < row && c < col;
    }
    
    private int index(int col, int r, int c) {
        return col * r + c;
    }
    
    private static class UnionFind {
        private int n;
        private int[] ids;
        public UnionFind(int row, int col) {
            n = row * col;
            ids = new int[n];
            for (int i = 0; i < n; i++) ids[i] = i;
        }
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            ids[i] = j;
            n--;
        }
        public int find(int p) {
            if (p == ids[p]) return p;
            return ids[p] = find(ids[p]);
        }
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public int count() {
            return n;
        }
    }
}