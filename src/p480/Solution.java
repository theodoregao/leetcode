package p480;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        initialize();
        double[] medians = new double[nums.length - k + 1];
        int i = 0;
        for (; i < k; i++) add(nums[i]);
        for (; i < nums.length; i++) {
            medians[i - k] = getMedian();
            add(nums[i]);
            remove(nums[i - k]);
        }
        medians[medians.length - 1] = getMedian();
        return medians;
    }
    
    private void initialize() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
    }
    
    private void add(int num) {
        if (num < getMedian()) max.add(num);
        else min.add(num);
        if (min.size() < max.size()) min.add(max.poll());
        else if (min.size() - max.size() > 1) max.add(min.poll());
    }
    
    private void remove(int num) {
        if (num < getMedian()) max.remove(num);
        else min.remove(num);
        if (min.size() < max.size()) min.add(max.poll());
        else if (min.size() - max.size() > 1) max.add(min.poll());
    }
    
    private double getMedian() {
        if (min.size() == 0) return 0;
        else if (min.size() == max.size()) return (1.0 * min.peek() + 1.0 * max.peek()) / 2;
        else return min.peek();
    }
    
    public static void main(String[] args) {
        for (double v: new Solution().medianSlidingWindow(new int[] {1,1,4,2,3}, 4))
            System.out.println(v);
    }
}