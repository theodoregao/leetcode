package p348;

public class TicTacToe {
    
    private int n;
    private int[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        return checkRow(row, player)
                || checkCol(col, player)
                || checkCross(row, col, player)
                ? player : 0;
    }
    
    private boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) if (board[row][i] != player) return false;
        return true;
    }
    
    private boolean checkCol(int col, int player) {
        for (int i = 0; i < n; i++) if (board[i][col] != player) return false;
        return true;
    }
    
    private boolean checkCross(int row, int col, int player) {
        if (row != col && row + col != n - 1) return false;
        return check00(player) || checknn(player);
    }
    
    private boolean check00(int player) {
        for (int i = 0; i < n; i++) if (board[i][i] != player) return false;
        return true;
    }
    
    private boolean checknn(int player) {
        for (int i = 0, j = n - 1; i < n; i++, j--) if (board[i][j] != player) return false;
        return true;
    }
    
    public static void main(String[] args) {
        TicTacToe tacToe = new TicTacToe(2);
        System.out.println(tacToe.move(0, 1, 1));
        System.out.println(tacToe.move(1, 1, 2));
        System.out.println(tacToe.move(1, 0, 1));
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */