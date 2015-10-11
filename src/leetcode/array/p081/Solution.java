package leetcode.array.p081;

public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target) != -1;
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        
        int mid = (left + right) >>> 1;
        
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        if (nums[mid] == target) return mid;
        
        if (nums[left] == nums[mid]) {
            while (left <= mid && nums[left] == nums[mid]) left++;
            return search(nums, left, right, target);
        }
        
        if (nums[right] == nums[mid]) {
            while (right >= mid && nums[right] == nums[mid]) right--;
            return search(nums, left, right, target);
        }
        
        if (nums[left] < nums[mid]) {
            // ÕÛµãÔÚÓÒ±ß
            if (target >= nums[left] && target < nums[mid])
                right = mid - 1;
            else left = mid + 1;
        }
        
        else {
            // ÕÛµãÔÚ×ó±ß
            if (target > nums[mid] && target <= nums[right])
                left = mid + 1;
            else right = mid - 1;
        }
        
        return search(nums, left, right, target);
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 8, 9, 1, 1, 1, 1, 1, 1, 2};
        for (int i = -1; i <= 11; i++)
            System.out.println(i + " : " + new Solution().search(nums, i));
    }
}