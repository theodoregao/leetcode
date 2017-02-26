package p493;

public class Solution {
    
    private int[] aux;
    
    // 据说还能用数组树来解决
    public int reversePairs(int[] nums) {
        aux = new int[nums.length];
        int cnt = mergeSortCount(nums, 0, nums.length - 1);;
        aux = null;
        return cnt;
    }
    
    private int mergeSortCount(int[] nums, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = (lo + hi) >> 1;
        int cnt = mergeSortCount(nums, lo, mid) + mergeSortCount(nums, mid + 1, hi);
        for (int i = mid + 1; i <= hi; i++) {
            int index = binarySearch(nums, lo, mid, nums[i]);
//            for (int k = 0; k <= mid; k++) System.out.print(nums[k] + " ");
//            System.out.println();
//            System.out.println("search for " + lo + ", " + mid + ", " + nums[i] + " returns " + index);
//            System.out.println(index + "... " + mid + " : " + (nums[index] / 2.0 > nums[i]) + " add " + (mid - ((nums[index] / 2.0 > nums[i]) ? index - 1 : index)));
            cnt += mid - ((nums[index] / 2.0 > nums[i]) ? index - 1 : index);
        }
        merge(nums, lo, mid, hi);
        return cnt;
    }
    
    private void merge(int[] items, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) aux[k] = items[k];
        for (int k = lo; k <= hi; k++)
            if (i > mid) items[k] = aux[j++];
            else if (j > hi) items[k] = aux[i++];
            else if (aux[j] < aux[i]) items[k] = aux[j++];
            else items[k] = aux[i++];
    }
    
    private int binarySearch(int[] items, int lo, int hi, int v) {
        if (lo >= hi) return lo;
        int mid = (lo + hi) >> 1;
        if (items[mid] / 2.0 > v) return binarySearch(items, lo, mid, v);
        else return binarySearch(items, mid + 1, hi, v);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution().reversePairs(new int[] {1,3,2,3,1}));
//        System.out.println(new Solution().reversePairs(new int[] {2,4,3,5,1}));
        System.out.println(new Solution().reversePairs(new int[] {1,2,3,4,5,4,3,2,1,9,8,7,6,5,4,3,2,1}));
    }
}