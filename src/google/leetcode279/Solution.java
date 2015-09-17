package google.leetcode279;

import java.util.Arrays;

/**
 * 
 * @author Theodore
 *
 *  ¼òµ¥DP
 */
public class Solution {
    public int numSquares(int n) {
        int[] nums = new int[n + 1];
        Arrays.fill(nums, Integer.MAX_VALUE);
        nums[0] = 0;
        
        int k = 0;
        while (++k <= n) {
            for (int i = 1; i * i <= k; i++) {
                nums[k] = Math.min(nums[k - i * i] + 1, nums[k]);
            }
//            System.out.println(k + " : " + nums[k]);
        }
        
        return nums[n];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(100));
    }
}