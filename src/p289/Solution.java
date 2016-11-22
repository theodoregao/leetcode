package p289;
public class Solution {
    
    public void gameOfLife(int[][] board) {
        int[][] state = new int[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                state[i][j] = board[i][j];
        
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                board[i][j] = check(state, i, j) ? 1 : 0;
    }
    
    private static final int[][] DIR = new int[][] {
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };
    
    private boolean check(int[][] board, int i, int j) {
        
        int liveCount = 0;
        for (int k = 0; k < DIR.length; k++) {
            int y = i + DIR[k][0];
            int x = j + DIR[k][1];
            if (x >= 0 && y >= 0 && y < board.length && x < board[0].length)
                liveCount += board[y][x];
        }
        
        return board[i][j] == 1
                ? liveCount == 2 || liveCount == 3
                : liveCount == 3;
    }
    
}