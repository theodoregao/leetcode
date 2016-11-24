package p462;

import java.util.Arrays;

public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        int m = nums[n / 2];
        for (int i = 0; i < n; i++)
            count += Math.abs(nums[i] - m);
        return count;
    }
}