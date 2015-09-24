package leetcode.facebook.p075;

/*
 * ÈýÂ·¿ìÅÅ
 */
public class Solution {
    public void sortColors(int[] nums) {
        int lt = 0, gt = nums.length - 1;
        int i = 0;
        
        while (i <= gt) {
            if (nums[i] < 1) exchange(nums, i++, lt++);
            else if (nums[i] > 1) exchange(nums, i, gt--);
            else i++;
        }
    }
    
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 2, 2, 1, 1, 0, 0, 1, 1};
        new Solution().sortColors(nums);
        
        for (int i = 0; i < nums.length; i++) System.out.println(nums[i]);
    }
}