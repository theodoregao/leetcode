package p041;
public class Solution {
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
//        for (int i = 0; i < n; i++)
//            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i])
//                swap(nums, nums[i] - 1, i);
        
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1])
                swap(nums, nums[i] - 1, i);
        }

        for (int i = 0; i < nums.length; i++) if (nums[i] != i + 1) return i + 1;
        
        return n + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[] {}));
        System.out.println(new Solution().firstMissingPositive(new int[] {1, 2, 0}));
        System.out.println(new Solution().firstMissingPositive(new int[] {3, 4, -1, 1}));
        System.out.println(new Solution().firstMissingPositive(new int[] {2, 2, 2, 2}));
        System.out.println(new Solution().firstMissingPositive(new int[] {1, 2, 2, 1, 3, 1, 0, 4, 0}));
        System.out.println(new Solution().firstMissingPositive(new int[] {-1, 4, 2, 1, 9, 10}));
    }
}