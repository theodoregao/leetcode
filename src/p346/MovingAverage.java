package p346;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    
    private int size;
    private long sum;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        sum += val;
        queue.offer(val);
        if (queue.size() > size) sum -= queue.poll();
        return 1.0 * sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */