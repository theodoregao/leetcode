package leetcode.array.p169;

public class Solution {
    public int majorityElement(int[] nums) {
        int m = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (m == nums[i]) count++;
            else if (--count <= 0) {
                m = nums[i];
                count = 1;
            }
        }
        
        return m;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[] {1, 2, 2, 2, 1, 1, 1, 1, 2, 3, 1, 4, 1}));
    }
}