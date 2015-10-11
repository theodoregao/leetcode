package leetcode.array.p152;

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int max = nums[0];
        int preMin = nums[0];
        int preMax = nums[0];
        int nextMin, nextMax;
        
        for (int i = 1; i < nums.length; i++) {
            nextMin = Math.min(preMin * nums[i], preMax * nums[i]);
            nextMax = Math.max(preMin * nums[i], preMax * nums[i]);
            preMin = Math.min(nextMin, nums[i]);
            preMax = Math.max(nextMax, nums[i]);
            max = Math.max(max, preMax);
        }

        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct(new int[] {-2, 1, 2, -3, 2, -3, 2, 0, 2}));
        System.out.println(new Solution().maxProduct(new int[] {-4, -3}));
    }
}