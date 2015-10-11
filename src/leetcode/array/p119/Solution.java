package leetcode.array.p119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<Integer>();
        
        int[] preRow = new int[rowIndex + 1];
        int[] nextRow = new int[rowIndex + 1];
        int[] temp;
        
        preRow[0] = 1;
        nextRow[0] = 1;
        
        for (int n = 0; n <= rowIndex; n++) {
            for (int i = 1; i <= n; i++) {
                nextRow[i] = preRow[i - 1] + preRow[i];
            }
            
            temp = preRow;
            preRow = nextRow;
            nextRow = temp;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) list.add(preRow[i]);
        return list;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) System.out.println(i + ": " + new Solution().getRow(i));
    }
}