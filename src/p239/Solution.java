package p239;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return new int[0];
        int[] max = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        for (int i = 0; i < k; i++) queue.add(nums[i]);
        max[0] =  queue.peek();
        for (int i = 1; i < max.length; i++) {
            queue.remove(nums[i - 1]);
            queue.add(nums[k + i - 1]);
            max[i] = queue.peek();
        }
        return max;
    }
    
    public static void main(String[] args) {
//        for (int n: new Solution().maxSlidingWindow(new int[] {3,3,5,5,6,7}, 3)) System.out.println(n);
        for (int n: new Solution().maxSlidingWindow(new int[] {1,-1}, 1)) System.out.println(n);
    }
}