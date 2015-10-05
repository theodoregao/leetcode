package leetcode.array.p045;

public class Solution {
    public int jump(int[] nums) {
        int counts = 0;
        int curr = 0;
        int next = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > next) return -1;
            if (i > curr) {
                curr = next;
                counts++;
            }
            next = Math.max(next, i + nums[i]);
        }
        
        return counts;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(new Solution().jump(nums));
    }
}