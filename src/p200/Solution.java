package p200;
public class Solution {
    
    private static int[][] DIR = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        UnionFind unionFind = new UnionFind(grid.length, grid[0].length);
        int nZeros = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++)
                if (grid[r][c] != '0') {
                    for (int i = 0; i < DIR.length; i++) {
                        int rr = r + DIR[i][0];
                        int cc = c + DIR[i][1];
                        if (valid(grid, rr, cc) && valid(grid, rr, cc) && grid[rr][cc] != '0')
                            unionFind.union(index(grid, r, c), index(grid, rr, cc));
                    }
                }
                else nZeros++;
        }
        return unionFind.count() - nZeros;
    }
    
    private boolean valid(char[][] grid, int r, int c) {
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }
    
    private int index(char[][] grid, int r, int c) {
        return r * grid[0].length + c;
    }
    
    private static class UnionFind {
        private int count;
        private int[] ids;
        public UnionFind(int row, int col) {
            int n = row * col;
            count = n;
            ids = new int[n];
            for (int i = 0; i < n; i++) ids[i] = i;
        }
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            ids[i] = j;
            count--;
        }
        public int find(int p) {
            if (p == ids[p]) return p;
            return ids[p] = find(ids[p]);
        }
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public int count() {
            return count;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][] {
                {'1','1','1','1','0'},
                {'0','0','0','1','0'},
                {'1','1','0','0','0'},
                {'1','0','1','0','1'}}));
    }
}