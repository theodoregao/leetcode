package p006;

public class Solution {
    
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) rows[i] = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            rows[getRowNumber(i, numRows)].append(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) sb.append(rows[i]);
        return sb.toString();
    }
    
    private int getRowNumber(int i, int n) {
        int size = n * 2 - 2;
        i %= size;
        if (i < n) return i;
        else return size - i;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().convert("ABCDEF", 1));
    }
}