package leetcode.array.p034;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid = Arrays.binarySearch(nums, target);
        
        if (mid < 0) return new int[] {-1, -1};
        
        int left, right;
        left = findLeft(nums, 0, mid);
        left = (nums[mid] == nums[left]) ? left : left + 1;
        right = findRight(nums, mid, nums.length - 1);
        right = (nums[mid] == nums[right]) ? right : right - 1;
        
        return new int[] {left, right};
    }

    private int findLeft(int[] nums, int left, int right) {
        int target = nums[right];
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) right = mid - 1;
            else left = mid + 1;
        }
        
        return left;
    }

    private int findRight(int[] nums, int left, int right) {
        int target = nums[left];
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {2, 2};
        int[] range = new Solution().searchRange(nums, 8);
        System.out.println(range[0] + ", " + range[1]);
    }
}