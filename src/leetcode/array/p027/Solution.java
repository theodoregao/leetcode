package leetcode.array.p027;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        
        int index = 0;
        for (int i = 0; i < nums.length; i++) if (nums[i] != val) nums[index++] = nums[i];
        return index;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1, 2, 0};
        int length = new Solution().removeElement(nums, 1);
        for (int i = 0; i < length; i++) System.out.println(nums[i]);
    }
}