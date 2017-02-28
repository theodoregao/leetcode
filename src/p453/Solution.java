package p453;
public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) {
                sum += (min - nums[i]) * i;
                min = nums[i];
            }
            else sum += nums[i] - min;
        }
        return sum;
    }
}