package p628;

import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * Math.max(nums[0] * nums[1], nums[nums.length - 2] * nums[nums.length - 3]);
    }
}