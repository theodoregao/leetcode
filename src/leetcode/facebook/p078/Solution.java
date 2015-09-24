package leetcode.facebook.p078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        subsets(result, nums, 0);
        
        return result;
    }

    private void subsets(List<List<Integer>> result, int[] nums, int index) {
        if (index >= nums.length) return;
        
        List<List<Integer>> newResult = new ArrayList<List<Integer>>();
        
        for (List<Integer> list: result) {
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(nums[index]);
            newResult.add(newList);
        }
        result.addAll(newResult);
        subsets(result, nums, index + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[] {1, 2, 3}));
    }
}