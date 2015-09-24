package leetcode.google.p004;

/**
 * 
 * @author Theodore
 *
 *  这题神烦，把神都能烦死
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, total / 2)
                    + findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, total / 2 + 1)) / 2.0;
        }
        else return findKth(nums1, 0, nums1.length, nums2, 0, nums2.length, (total + 1) / 2);
    }

    private int findKth(int[] a, int sa, int la, int[] b, int sb, int lb, int k) {
//        System.out.println(sa + ", " + la + " : " + sb + ", " + lb + " : " + k);
        if (la > lb) return findKth(b, sb, lb, a, sa, la, k);
        if (la <= 0) return b[sb + k - 1];
        if (k <= 1) return Math.min(a[sa], b[sb]);
        
        if (b[sb + lb / 2] >= a[sa + la / 2]) {
            if (la / 2 + lb / 2 + 1 >= k) return findKth(a, sa, la, b, sb, lb / 2, k);
            else return findKth(a, sa + la / 2 + 1, la - la / 2 - 1, b, sb, lb, k - la / 2 - 1);
        }
        else {
            if (la / 2 + lb / 2 + 1 >= k) return findKth(a, sa, la / 2, b, sb, lb, k);
            else return findKth(a, sa, la, b, sb + lb / 2 + 1, lb - lb / 2 - 1, k - lb / 2 - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};
        
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}