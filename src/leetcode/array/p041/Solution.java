package leetcode.array.p041;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            while (index > 0 && index <= nums.length && nums[index - 1] != index) {
                int temp = nums[index - 1];
                nums[index - 1] = index;
                index = temp;
            }
        }
        int i;
        for (i = 0; i < nums.length; i++) if (nums[i] != i + 1) return i + 1;
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {2, 1};
        System.out.println(new Solution().firstMissingPositive(nums));
    }
}