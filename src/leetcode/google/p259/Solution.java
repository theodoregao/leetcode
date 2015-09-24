package leetcode.google.p259;

import java.util.Arrays;

/**
 * 
 * @author Theodore
 *
 *  确定一个，再选择另外俩
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int count = 0;
        int i, l, r;
        for (i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] >= target) {
                    r--;
                }
                else {
                    count += r - l;
                    l++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {-2, 0, 1, 3};
        System.out.println(new Solution().threeSumSmaller(nums, 2));
    }
}