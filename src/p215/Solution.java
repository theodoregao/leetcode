package p215;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) queue.poll();
        }
        return queue.poll();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{1,3,5,2,4}, 1));
    }
}