package p312;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxCoinsSlow(int[] nums) {
        Map<String, Integer> map = new HashMap<>();
        map.put("", 0);
        return recursive(map, nums);
    }
    
    private int recursive(Map<String, Integer> map, int[] nums) {
        String encode = encoding(nums);
//        System.out.println("recursive() encode: " + encode);
        if (map.containsKey(encode)) return map.get(encode);
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            max = Math.max(max, burst(nums, i) + recursive(map, subArray(nums, i)));
        map.put(encode, max);
        return max;
    }
    
    private String encoding(int[] nums) {
//        return nums.hashCode();
        StringBuffer sb = new StringBuffer();
        for (int i: nums) sb.append(i).append("#");
        return sb.toString();
    }
    
    private int burst(int[] nums, int index) {
        if (nums.length == 1) return nums[0];
        if (index == 0) return nums[0] * nums[1];
        if (index == nums.length - 1) return nums[nums.length - 2] * nums[nums.length - 1];
        return nums[index - 1] * nums[index] * nums[index + 1];
    }
    
    private int lastBurst(int[] nums, int s, int e, int index) {
        return (s - 1 >= 0 ? nums[s - 1] : 1) * nums[index] * (e + 1 < nums.length ? nums[e + 1] : 1);
    }
    
    private int[] subArray(int[] nums, int index) {
//        System.out.println("subArray() " + nums.length + ", " + index);
        int[] sub = new int[nums.length - 1];
        for (int i = 0, j = 0; i < nums.length; i++)
            if (index != i) sub[j++] = nums[i];
        return sub;
    }
    
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][n]; // define dp as max coin as range i to j
        for (int len = 1; len <= n; len++) {
            for (int s = 0, e = s + len - 1; e < n; s++, e++)
                for (int lastBurstIndex = s; lastBurstIndex <= e; lastBurstIndex++)
                    dp[s][e] = Math.max(dp[s][e], lastBurst(nums, s, e, lastBurstIndex) +
                            (lastBurstIndex > 0 ? dp[s][lastBurstIndex - 1] : 0) +
                            (lastBurstIndex < n - 1 ? dp[lastBurstIndex + 1][e] : 0));
        }
        return dp[0][nums.length - 1];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[] {3,1,5,8,1,2,3,4,2,1,2,3,4,1}));
    }
}