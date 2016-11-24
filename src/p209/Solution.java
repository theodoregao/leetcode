package p209;
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0, j = 0;
        while (j < n) {
            sum += nums[j++];
            if (sum >= s) {
                while (sum >= s) {
                    min = Math.min(min, j - i);
                    sum -= nums[i++];
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
        System.out.println(new Solution().minSubArrayLen(4, new int[] {1, 4, 4}));
        System.out.println(new Solution().minSubArrayLen(11, new int[] {1, 2, 3, 4, 5}));
    }
}