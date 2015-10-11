package leetcode.array.p090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> subsets = new HashSet<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        subsetsWithDup(nums, 0, subsets);
        return new ArrayList<List<Integer>>(subsets);
    }

    private void subsetsWithDup(int[] nums, int n, Set<List<Integer>> subsets) {
        if (n >= nums.length) return;

        Set<List<Integer>> newSubsets = new HashSet<List<Integer>>();
        for (List<Integer> subset: subsets) {
            List<Integer> newSubset = new ArrayList<Integer>(subset);
            newSubset.add(nums[n]);
            newSubsets.add(newSubset);
        }
        subsets.addAll(newSubsets);
        subsetsWithDup(nums, n + 1, subsets);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[] {1, 2, 2}).size());
        System.out.println(new Solution().subsetsWithDup(new int[] {9, 0, 3, 5, 7}).size());
    }
}