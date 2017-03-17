package p376;
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
//        return wiggleMaxLengthSlowDp(nums);
        
//        ups = new int[nums.length];
//        downs = new int[nums.length];
//        int max = Math.max(wiggleMaxLengthDpUpRecursive(nums, nums.length - 1), 
//                wiggleMaxLengthDpDownRecursive(nums, nums.length - 1));
//        ups = null;
//        downs = null;
//        return max;
        
        return wiggleMaxLengthDp(nums);
    }
    

    public int wiggleMaxLengthDp(int[] nums) {
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[i - 1]) up = down + 1;
            else if (nums[i] < nums[i - 1]) down = up + 1;
        return Math.max(up, down);
    }

    private int[] ups;
    private int[] downs;
    public int wiggleMaxLengthDpUpRecursive(int[] nums, int n) {
        if (n == 0) return 1;
        else if (ups[n] != 0) return ups[n];
        ups[n] = nums[n - 1] < nums[n]
                ? wiggleMaxLengthDpDownRecursive(nums, n - 1) + 1
                : wiggleMaxLengthDpUpRecursive(nums, n - 1);
        return ups[n];
    }

    public int wiggleMaxLengthDpDownRecursive(int[] nums, int n) {
        if (n == 0) return 1;
        else if (downs[n] != 0) return downs[n];
        downs[n] = nums[n - 1] > nums[n]
                ? wiggleMaxLengthDpUpRecursive(nums, n - 1) + 1
                : wiggleMaxLengthDpDownRecursive(nums, n - 1);
        return downs[n];
    }
    
    public int wiggleMaxLengthSlowDp(int[] nums) {
        int[][][] dp = new int[nums.length][nums.length][2];
        int max = 0;
        for (int i = 0; i < nums.length; i++) dp[i][i][0] = dp[i][i][1] = 1;
        for (int d = 1; d < nums.length; d++) {
            for (int i = 0, j = d; j < nums.length; i++, j++) {
                dp[i][j][0] = dp[i][j][1] = 1;
                for (int k = j - 1; k >= i; k--) {
                    if (nums[k] < nums[j]) dp[i][j][1] = Math.max(dp[i][j][1], dp[i][k][0] + 1);
                    else if (nums[k] > nums[j]) dp[i][j][0] = Math.max(dp[i][j][0], dp[i][k][1] + 1);
                    max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(new int[] {0,0}));
        System.out.println(new Solution().wiggleMaxLength(new int[] {1,7,4,9,2,5}));
        System.out.println(new Solution().wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new Solution().wiggleMaxLength(new int[] {1,2,3,4,5,6,7,8,9}));
        System.out.println(new Solution().wiggleMaxLength(new int[] {1,7,4,9,2,5,1,7,4,9,2,5,1,17,5,10,13,15,15,0,0,0,14,15,16,17,18,10,5,16,8,1,2,3,4,5,6,7,8,9}));
    }
}