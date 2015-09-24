package leetcode.facebook.p080;
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 2;
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        
        return index;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 5, 5, 5, 6, 7, 7, 7, 7};
        int index = new Solution().removeDuplicates(nums);
        System.out.println(index);
        for (int i = 0; i < index; i++)
            System.out.println(nums[i]);
    }
}