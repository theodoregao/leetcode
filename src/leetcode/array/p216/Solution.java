package leetcode.array.p216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        combinationSum3(lists, new ArrayList<Integer>(), k, n, 1);
        return lists;
    }

    private void combinationSum3(List<List<Integer>> lists, List<Integer> list, int k, int n, int m) {
        if (k < 0 || n < 0) return;
        
        if (k == 0 && n == 0) lists.add(new ArrayList<Integer>(list));
        
        for (int i = m; i <= 9; i++) {
            if (n - i >= 0) {
                list.add(i);
                combinationSum3(lists, list, k - 1, n - i, i + 1);
                list.remove(list.indexOf(i));
            }
        }
    }
    
    public static void main(String[] args) {
        for (List<Integer> list: new Solution().combinationSum3(3, 15)) {
            for (Integer n: list) System.out.println(n);
            System.out.println();
        }
    }
}