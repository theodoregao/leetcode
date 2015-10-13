package leetcode.array.p268;

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = 0;
        
        for (int i = 1; i <= n; i++) {
            x ^= i;
            x ^= nums[i - 1];
        }
        
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[] {0, 1, 2, 4, 5, 6, 7, 8}));
    }
}