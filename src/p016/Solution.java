package p016;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (Math.abs(target - sum) < Math.abs(target - closest)) closest = sum;
                if (sum > target) e--;
                else s++;
            }
        }
        return closest;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(new int[] {-3,-2,-5,3,-4}, -1));
    }
}