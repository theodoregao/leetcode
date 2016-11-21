package p036;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        if (board.length != 9 || board[0].length != 9) return false;
        
        for (int i = 0; i < 9; i++) for (int j = 0; j < 9; j++)
            if (board[i][j] != '.' && !check(board, i, j)) return false;
        
        return true;
    }
    
    private boolean check(char[][] board, int x, int y) {
        return checkCell(board, x, y) && checkCross(board, x, y);
    }
    
    private boolean checkCell(char[][] board, int x, int y) {
        final int I = x / 3 * 3;
        final int J = y / 3 * 3;
        for (int i = I + 0; i < I + 3; i++)
            for (int j = J + 0; j < J + 3; j++) {
                if (x == i && y == j) continue;
                if (board[i][j] == board[x][y]) return false;
            }
        return true;
    }
    
    private boolean checkCross(char[][] board, int x, int y) {
        for (int i = 0; i < 9; i++) {
            if (i != x && board[i][y] == board[x][y]) return false;
            if (i != y && board[x][i] == board[x][y]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String[] boards = new String[] {
                ".87654321","2........","3........","4........","5........","6........","7........","8........","9........"
        };
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) board[i] = boards[i].toCharArray();
        
        System.out.println(new Solution().isValidSudoku(board));
        
    }
}