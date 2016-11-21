package p051;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        search(solutions, new int[n][n], n, 0);
        return solutions;
    }
    
    private void search(List<List<String>> solutions, int[][] board, int n, int m) {
        if (m == n) {
            solutions.add(boardToSolution(board));
        }
        else {
            for (int i = 0; i < n; i++) {
                if (!canPlace(board, m, i)) continue;
                board[m][i] = 1;
                search(solutions, board, n, m + 1);
                board[m][i] = 0;
            }
        }
    }
    
    private boolean canPlace(int[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 0) return false;
            if (board[i][col] != 0) return false;
            for (int j = 0; j < board.length; j++) {
                if (i + j == row + col && board[i][j] != 0) return false;
                if (i - j == row - col && board[i][j] != 0) return false;
            }
        }
        return true;
    }
    
    private List<String> boardToSolution(int[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) sb.append(board[i][j] != 1 ? '.' : 'Q');
            solution.add(sb.toString());
        }
        return solution;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(5).size());
    }
}