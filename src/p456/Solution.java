package p456;
public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        mins[0] = maxs[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (mins[j] < nums[i] && nums[i] < maxs[j]) return true;
            }

            if (nums[i] < mins[i - 1]) {
                mins[i] = nums[i];
                maxs[i] = nums[i];
            }
            else if (nums[i] > maxs[i - 1]) {
                mins[i] = mins[i - 1];
                maxs[i] = Math.max(maxs[i - 1], nums[i]);
            }
            else {
                mins[i] = mins[i - 1];
                maxs[i] = maxs[i - 1];
            }
            
//            System.out.println(mins[i] + ", " + maxs[i]);
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[] {1,2,3,4}));
        System.out.println(new Solution().find132pattern(new int[] {3,1,4,2}));
        System.out.println(new Solution().find132pattern(new int[] {-1,3,2,0}));
        System.out.println(new Solution().find132pattern(new int[] {-2,1,-1}));
        System.out.println(new Solution().find132pattern(new int[] {4,1,3,2}));
        System.out.println(new Solution().find132pattern(new int[] {3,5,0,3,4}));
        System.out.println(new Solution().find132pattern(new int[] {2,2,3,1}));
    }
}