package leetcode.array.p055;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length < 2) return true;
        
        int maxNext = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (maxNext < i) return false;
            maxNext = Math.max(maxNext, i + nums[i]);
            if (maxNext >= nums.length - 1) return true;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[] {3, 2, 1, 0, 4}));
        System.out.println(new Solution().canJump(new int[] {2, 0, 0}));
    }
}