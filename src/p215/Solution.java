package p215;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private int findKthLargest_heap(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }
    
    private int findKthLargest_quick_sort(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k--;
        while (true) {
            if (lo >= hi) return nums[lo];
            int j = partition(nums, lo, hi);
            if (j == k) return nums[j];
            if (j < k) lo = j + 1;
            else hi = j - 1;
        }
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (v < nums[++i]) if (i >= hi) break;
            while (v > nums[--j]) ;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] items, int i, int j) {
        int temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    
    public int findKthLargest(int[] nums, int k) {
//        return findKthLargest_heap(nums, k);
        return findKthLargest_quick_sort(nums, k);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{1,3,5,2,4}, 1));
        System.out.println(new Solution().findKthLargest(new int[]{1,3,5,2,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{1,3,5,2,4}, 3));
        System.out.println(new Solution().findKthLargest(new int[]{1,3,5,2,4}, 4));
        System.out.println(new Solution().findKthLargest(new int[]{1,3,5,2,4}, 5));

        System.out.println(new Solution().findKthLargest(new int[] {1}, 1));
        System.out.println(new Solution().findKthLargest(new int[] {2,1}, 1));
        System.out.println(new Solution().findKthLargest(new int[] {2,1}, 2));
    }
}