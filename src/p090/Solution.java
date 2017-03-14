package p090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsetsWithDup(subsets, subset, nums, 0);
        return subsets;
    }
    
    private void subsetsWithDup(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int n) {
        subsets.add(new ArrayList<>(subset));
        while (n < nums.length) {
            subset.add(nums[n]);
            subsetsWithDup(subsets, subset, nums, n + 1);
            subset.remove(subset.size() - 1);
            n++;
            while (n < nums.length && nums[n - 1] == nums[n]) n++;
        }
    }
}