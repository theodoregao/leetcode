package leetcode.array.p189;

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, k - 1);
    }
    
    private void reverse(int[] nums, int s, int e) {
        int temp;
        while (s < e) {
            temp = nums[s];
            nums[s++] = nums[e];
            nums[e--] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 16);
        for (int i = 0; i < nums.length; i++) System.out.println(nums[i]);
    }
}