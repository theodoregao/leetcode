package p031;
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for ( ; i >= 0; i--) if (nums[i] < nums[i + 1]) {
            int j = nums.length - 1;
            for ( ; nums[j] <= nums[i]; j--) ;
            swap(nums, i, j);
            reverse(nums, i + 1, nums.length - 1);
            break;
        }
        if (i == -1) reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) swap(nums, lo++, hi--);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {1,4,3,2};
        new Solution().nextPermutation(nums);
        for (int i: nums) System.out.println(i);
    }
}