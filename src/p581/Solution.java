package p581;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = new int[nums.length];
        for (int i = 0; i < nums.length; i++) sorted[i] = nums[i];
        Arrays.sort(sorted);
        int lo = 0, hi = nums.length - 1;
        while (lo < hi && nums[lo] == sorted[lo]) lo++;
        while (hi > lo && nums[hi] == sorted[hi]) hi--;
        return hi > lo ? hi - lo + 1 : 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[] {1, 15, 2, 3, 17}));
    }
}