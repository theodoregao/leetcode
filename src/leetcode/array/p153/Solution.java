package leetcode.array.p153;

public class Solution {
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left < right && nums[left] > nums[right]) {
            mid = (left + right) >>> 1;
            
            if (nums[mid] < nums[right]) {
                right = mid;
            }
            
            else {
                left = mid + 1;
            }
        }
        
        return nums[left];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[] {6, 7, 8, 9, 1, 2, 3, 4, 5}));
    }
}