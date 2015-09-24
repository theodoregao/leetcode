package leetcode.facebook.p079;
public class Solution {
    private final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0 || board[0].length <= 0 || word == null) return false;
        
        boolean[][] visited = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) visited[i] = new boolean[board[0].length];
        
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (exist(board, visited, word, i, j))
                    return true;
        
        return false;
    }

    private boolean exist(char[][] board, boolean[][] visited, String word, int i, int j) {
        if (word.length() <= 0) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                visited[i][j] || board[i][j] != word.charAt(0)) return false;
        
        visited[i][j] = true;
        for (int k = 0; k < DIRS.length; k++) {
            if (exist(board, visited, word.substring(1), i + DIRS[k][0], j + DIRS[k][1]))
                return true;
        }
        visited[i][j] = false;
        
        return false;
    }
    
    public static void main(String[] args) {
        char[][] board = new char[][] {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new Solution().exist(board, "ABCCED"));
        System.out.println(new Solution().exist(board, "SEE"));
        System.out.println(new Solution().exist(board, "ABCB"));
    }
}