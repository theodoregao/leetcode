package p477;
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        int ones, zeros;
        while (!allZero(nums)) {
            ones = zeros = 0;
            for (int i = 0; i < nums.length; i++)
                if ((nums[i] & 1) == 0) zeros++; else ones++;
            count += ones * zeros;
            for (int i = 0; i < nums.length; i++) nums[i] >>>= 1;
        }
        return count;
    }
    
    private boolean allZero(int[] nums) {
        for (int i = 0; i < nums.length; i++) if (nums[i] != 0) return false;
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().totalHammingDistance(new int[] {4,14,2}));
    }
}