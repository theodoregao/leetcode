package leetcode.facebook.p209;
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        long sum = 0;
        int left = 0, right = 0;
        int length = Integer.MAX_VALUE;
        while (left <= right && right < nums.length) {
            while (right < nums.length && sum < s) sum += nums[right++];
            while (left < right && sum >= s){
                length = Math.min(length, right - left);
                sum -= nums[left++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(11, new int[] {1, 2, 3, 4, 5}));
        System.out.println(new Solution().minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 1, 3}));
    }
}