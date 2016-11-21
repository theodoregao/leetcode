package p046;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        recursive(results, nums, new ArrayList<Integer>());
        return results;
    }
    
    private void recursive(List<List<Integer>> results, int[] nums, List<Integer> result) {
        if (nums.length == 0) {
            List<Integer> rs = new ArrayList<>();
            rs.addAll(result);
            results.add(rs);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            result.add(nums[i]);
            recursive(results, removeAt(nums, i), result);
            result.remove(result.size() - 1);
        }
    }
    
    private int[] removeAt(int[] ints, int pos) {
        int[] newInts = new int[ints.length - 1];
        for (int i = 0; i < pos; i++) newInts[i] = ints[i];
        for (int i = ints.length - 1; i > pos; i--) newInts[i - 1] = ints[i];
        return newInts;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> results = new Solution().permute(new int[] {1, 2, 3, 4});

        System.out.println("size: " + results.size());
        
        for (List<Integer> result: results) {
            for (Integer i: result) System.out.print(i);
            System.out.println();
        }
    }
}