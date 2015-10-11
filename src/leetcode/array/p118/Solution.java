package leetcode.array.p118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> trangle = new ArrayList<List<Integer>>();

        if (numRows <= 0) return trangle;
        
        int[] preRow = new int[numRows + 2];
        int[] nextRow = new int[numRows + 1];
        int[] temp;
        
        preRow[0] = 1;
        nextRow[0] = 1;
        
        for (int n = 1; n <= numRows; n++) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            for (int i = 1; i < n; i++) {
                nextRow[i] = preRow[i - 1] + preRow[i];
                list.add(nextRow[i]);
            }
            trangle.add(list);
            
            temp = preRow;
            preRow = nextRow;
            nextRow = temp;
        }
        
        return trangle;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }
}