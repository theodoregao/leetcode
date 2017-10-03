package p004;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array = merge(nums1, nums2);
        if (array.length % 2 != 0) return array[array.length / 2];
        return (array[(array.length - 1) / 2] + array[array.length / 2]) / 2.0;
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        for (int k = 0; k < array.length; k++) {
            if (i >= nums1.length) array[k] = nums2[j++];
            else if (j >= nums2.length) array[k] = nums1[i++];
            else if (nums1[i] > nums2[j]) array[k] = nums2[j++];
            else array[k] = nums1[i++];
        }
        return array;
    }
}