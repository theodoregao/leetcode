package p283;
public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for (; i < nums.length; i++) if (nums[i] != 0) nums[j++] = nums[i];
        for (; j < nums.length; j++) nums[j] = 0;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        for (int n: nums) System.out.println(n);
    }
}