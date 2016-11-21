package p027;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i, j;
        for (i = 0, j = 0; i < nums.length; ) {
            if (val == nums[i]) i++;
            else nums[j++] = nums[i++];
        }
        return j;
    }
}