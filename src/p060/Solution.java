package p060;
public class Solution {
    public String getPermutation(int n, int k) {
        char[] nums = new char[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = (char) ('0' + i);
        for (int i = 1; i < k; i++) next(nums);
        return new String(nums);
    }
    
    private void next(char[] nums) {
        int i = nums.length - 2;
        for ( ; i >= 0; i--) if (nums[i] < nums[i + 1]) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
            reverse(nums, i + 1, nums.length - 1);
            break;
        }
        if (i == -1) reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(char[] nums, int lo, int hi) {
        while (lo < hi) swap(nums, lo++, hi--);
    }
    
    private void swap(char[] nums, int i, int j) {
        char c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
    
    public static void main(String[] args) {
        for (int k = 1; k <= 10; k++) System.out.println(new Solution().getPermutation(3, k));
    }
}