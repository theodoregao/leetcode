package p485;
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                size = 0;
                while (i < nums.length && nums[i] == 1) {
                    max = Math.max(max, ++size);
                    i++;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[] {1,1,0,1}));
        System.out.println(new Solution().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
    }
}