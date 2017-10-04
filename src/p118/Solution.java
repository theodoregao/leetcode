package p118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if (numRows == 0) return list;
        list.add(Arrays.asList(new Integer[] {1}));
        for (int i = 2; i <= numRows; i++) {
            Integer[] row = new Integer[i];
            List<Integer> preRow = list.get(i - 2);
            row[0] = row[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) row[j] = preRow.get(j - 1) + preRow.get(j);
            list.add(Arrays.asList(row));
        }
        return list;
    }
    
    public static void main(String[] args) {
        for (List<Integer> row: new Solution().generate(5)) {
            for (Integer item: row) System.out.print(item + " ");
            System.out.println();
        }
    }
}