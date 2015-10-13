package leetcode.array.p154;

public class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left < right && nums[left] >= nums[right]) {
            if (nums[left] == nums[right]) {
                right--;
                continue;
            }
            
            mid = (left + right) >>> 1;
            
            if (nums[mid] <= nums[right]) {
                right = mid;
            }
            
            else {
                left = mid + 1;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[] {3, 1, 3}));
        System.out.println(new Solution().findMin(new int[] {2, 0, 1, 1, 1}));
        System.out.println(new Solution().findMin(new int[] {6, 6, 6, 6, 7, 8, 8, 8, 8, 9, 1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5}));
    }
}