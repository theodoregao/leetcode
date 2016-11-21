package p351;

public class Solution {
    
    private static int[][] SKIPS = new int[10][10];
    
    static {
        SKIPS[1][3] = SKIPS[3][1] = 2;
        SKIPS[1][7] = SKIPS[7][1] = 4;
        SKIPS[3][9] = SKIPS[9][3] = 6;
        SKIPS[7][9] = SKIPS[9][7] = 8;
        SKIPS[1][9] = SKIPS[9][1] = 5;
        SKIPS[2][8] = SKIPS[8][2] = 5;
        SKIPS[3][7] = SKIPS[7][3] = 5;
        SKIPS[4][6] = SKIPS[6][4] = 5;
    }
    
    public int numberOfPatterns(int m, int n) {
        return dfs(m, n, 1) * 4 + dfs(m, n, 2) * 4 + dfs(m, n, 5);
    }
    
    private int dfs(int m, int n, int pos) {
        boolean[] visited = new boolean[10];
        visited[0] = true;
        visited[pos] = true;
        return dfs(m, n, visited, pos, 1);
    }
    
    private int dfs(int m, int n, boolean[] visited, int pos, int size) {
        if (size >= n) return 1;
        int count = 0;
        if (size >= m) count++;
        for (int i = 1; i <= 9; i++) {
            if (!visited[i] && visited[SKIPS[pos][i]]) {
                visited[i] = true;
                count += dfs(m, n, visited, i, size + 1);
                visited[i] = false;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfPatterns(1, 1));
        System.out.println(new Solution().numberOfPatterns(2, 2));
        System.out.println(new Solution().numberOfPatterns(3, 3));
        System.out.println(new Solution().numberOfPatterns(4, 4));
        System.out.println(new Solution().numberOfPatterns(5, 5));
        System.out.println(new Solution().numberOfPatterns(6, 6));
    }
}