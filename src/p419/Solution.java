package p419;
public class Solution {
    
    public int countBattleships(char[][] board) {
        int n = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X') continue;
                    else n++;
                }
            }
        }
        return n;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countBattleships(
            new char[][] {
                "X..X".toCharArray(),
                "...X".toCharArray(),
                "...X".toCharArray()
        }));
    }
    
}