package p308;
public class NumMatrix {
    
    int[][] matrix;
    int[][] cc;
    int n, m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = n == 0 ? 0 : matrix[0].length;
        this.matrix = new int[n + 1][m + 1];
        cc = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                update(i, j, matrix[i][j]);
    }
    
    private int lowbit(int n) {
        return n & -n;
    }
    
    public void update(int row, int col, int val) {
        int delta = val - matrix[row + 1][col + 1];
        matrix[row + 1][col + 1] = val;
        for (int i = row + 1; i <= n; i += lowbit(i))
            for (int j = col + 1; j <= m; j += lowbit(j))
                cc[i][j] += delta;
    }
    
    private int sum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= lowbit(i))
            for (int j = col + 1; j > 0; j -= lowbit(j))
                sum += cc[i][j];
        return sum;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row2, col1 - 1) - sum(row1 - 1, col2);
    }
    
    public static void main(String[] args) {
        NumMatrix nm = new NumMatrix(new int[][] {{1}});
        nm.update(0, 0, -1);
        System.out.println(nm.sumRegion(0,0,0,0));
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */