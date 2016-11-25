package p162;
public class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            int mid2 = mid + 1;
            if (nums[mid] < nums[mid2]) lo = mid2;
            else hi = mid;
        }
        return lo;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[] {1, 2}));
    } 
}