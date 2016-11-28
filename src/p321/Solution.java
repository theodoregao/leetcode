package p321;
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        int[] temp;
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            temp = merge(getMax(nums1, i), getMax(nums2, k - i));
            if (cmp(max, 0, temp, 0) < 0) max = temp;
        }
        return max;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0, k = 0; k < nums1.length + nums2.length; k++) {
            if (i >= nums1.length) nums[k] = nums2[j++];
            else if (j >= nums2.length) nums[k] = nums1[i++];
            else if (cmp(nums1, i, nums2, j) < 0) nums[k] = nums2[j++];
            else nums[k] = nums1[i++];
        }
        return nums;
    }
    
    private int[] getMax(int[] nums, int size) {
        int[] max = new int[size];
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            while (size - j < n - i && j > 0 && max[j - 1] < nums[i]) j--;
            if (j < size) max[j++] = nums[i];
        }
        return max;
    }
    
    private int cmp(int[] left, int i, int[] right, int j) {
        for (; i < left.length && j < right.length; i++, j++)
            if (left[i] < right[j]) return -1;
            else if (left[i] > right[j]) return 1;
        if (i == left.length && j == right.length) return 0;
        else if (i == left.length) return -1;
        else return 1;
    }
    
    private static void print(int[] num) {
        for (int i: num) System.out.println(i);
        System.out.println();
    }
    
    public static void main(String[] args) {
//        print(new Solution().maxNumber(new int[] {6, 7},  new int[] {6, 0, 4}, 5));
        print(new Solution().maxNumber(new int[] {8, 6, 9},  new int[] {1, 7, 5}, 3));
    }
}