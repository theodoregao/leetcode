package leetcode.array.p053;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]);
            max = Math.max(max, sum);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4, 2}));
        System.out.println(new Solution().maxSubArray(new int[] {8, -19, 5, -4, 20}));
        System.out.println(new Solution().maxSubArray(new int[] {-2, 1}));
    }
}