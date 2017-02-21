package p486;
public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) total += nums[i];
        return pick(nums, 0, nums.length - 1, 0) >= (total + 1) / 2;
    }
    
    private int pick(int[] nums, int s, int e, int sum) {
        if (s == e) return nums[s];
        if (s == e - 1) return Math.max(nums[s], nums[e]);
        // should add memoization here. just skip it for now, even it is so simple.
        return Math.max(nums[s] + Math.min(pick(nums, s + 2, e, sum + nums[s]), pick(nums, s + 1, e - 1, sum + nums[s])),
                nums[e] + Math.min(pick(nums, s + 1, e - 1, sum + nums[e]), pick(nums, s, e - 2, sum + nums[e])));
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().PredictTheWinner(new int[] {1, 3, 1}));
    }
}