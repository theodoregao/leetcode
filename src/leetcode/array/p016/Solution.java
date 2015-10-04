package leetcode.array.p016;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        
        if (nums == null || nums.length < 3) return min;
        
        Arrays.sort(nums);
        
        int minDiff = Integer.MAX_VALUE;
        int diff, sum;
        
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                diff = sum - target;
                if (Math.abs(diff) < minDiff) {
                    minDiff = Math.abs(diff);
                    min = sum;
                }
                
                if (diff == 0) return target;
                else if (diff < 0) left++;
                else right--;
            }
        }
        
        return min;
    }
}