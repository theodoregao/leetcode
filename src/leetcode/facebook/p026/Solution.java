package leetcode.facebook.p026;
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int pos = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pos - 1] != nums[i]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
}