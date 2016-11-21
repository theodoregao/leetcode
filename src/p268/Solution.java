package p268;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            n ^= i;
            n ^= nums[i];
        }
        return n ^ nums.length;
    }
}