package leetcode.array.p035;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int pos = binarySearch(nums, target);
        return (pos >= 0) ? pos : -(pos + 1);
    }
    
    private int binarySearch(int[]nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (midVal == target) return mid;
            else if (midVal < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return -(left + 1);
    }
    
    public static void main(String[] args) {
        int[] nums = new int[1];
        System.out.println(new Solution().searchInsert(nums, 2));
    }
}