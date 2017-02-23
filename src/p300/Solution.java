package p300;
public class Solution {
    public int lengthOfLIS(int[] nums) {
    	int n = nums.length;
    	if (n == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1;
        for (int i = 1; i < n; i++) {
        	dp[i] = 1;
        	for (int j = 0; j < i; j++) if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
        	max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
//		System.out.println(new Solution().lengthOfLIS(new int[] {-2, -1}));
//		System.out.println(new Solution().lengthOfLIS(new int[] {4,10,4,3,8,9}));
		System.out.println(new Solution().lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
	}
}