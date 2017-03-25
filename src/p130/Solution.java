package p130;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    private int[][] DIR = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        UnionFind unionFind = new UnionFind(row, col);
        
        for (int r = 0; r < row; r++)
            for (int c = 0; c < col; c++)
                if (board[r][c] == 'O')
                    for (int i = 0; i < DIR.length; i++) {
                        int rr = r + DIR[i][0];
                        int cc = c + DIR[i][1];
                        if (valid(board, rr, cc) && board[rr][cc] == 'O')
                            unionFind.union(index(board, r, c), index(board, rr, cc));
                    }
        
         Set<Integer> set = new HashSet<>();
         for (int r = 0; r < row; r++) {
             if (board[r][0] == 'O') set.add(unionFind.find(index(board, r, 0)));
             if (board[r][col - 1] == 'O') set.add(unionFind.find(index(board, r, col - 1)));
         }
         for (int c = 0; c < col; c++) {
             if (board[0][c] == 'O') set.add(unionFind.find(index(board, 0, c)));
             if (board[row - 1][c] == 'O') set.add(unionFind.find(index(board, row - 1, c)));
         }
         
         for (int r = 0; r < row; r++)
             for (int c = 0; c < col; c++)
                 if (board[r][c] == 'O' && !set.contains(unionFind.find(index(board, r, c))))
                     board[r][c] = 'X';
    }
    
    private boolean valid(char[][] board, int r, int c) {
        return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
    }
    
    private int index(char[][] board, int r, int c) {
        return r * board[0].length + c;
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
            else return ids[p] = find(ids[p]);
        }
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        public int count() {
            return n;
        }
    }
}