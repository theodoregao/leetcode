package google.leetcode280;

/**
 * 
 * @author Theodore
 *
 *  用数学归纳法很容易证明
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int flag = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] * flag > nums[i] * flag)
                swap(nums, i - 1, i);
            
            flag *= -1;
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}