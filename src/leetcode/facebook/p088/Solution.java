package leetcode.facebook.p088;
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n;
        while (m > 0 && n > 0) nums1[--index] = (nums1[m - 1] > nums2[n - 1]) ? nums1[--m] : nums2[--n];
        while (n > 0) nums1[--index] = nums2[--n];
    }
    
    public static void main(String[] args) {
        int[] nums1 = new int[] {3, 4, 6, 9, 0, 0, 0, 0};
        int[] nums2 = new int[] {1, 5, 7, 8};
        
        new Solution().merge(nums1, 4, nums2, 4);
        
        for (int i = 0; i < nums1.length; i++)
            System.out.println(nums1[i]);
    }
}