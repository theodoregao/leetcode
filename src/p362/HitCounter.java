package p362;

import java.util.HashMap;
import java.util.Map;

public class HitCounter {
    
    private Map<Integer, Integer> hits;

    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new HashMap<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.put(timestamp, hits.containsKey(timestamp) ? hits.get(timestamp) + 1 : 1);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int hit = 0;
        for (int i = timestamp; i > timestamp - 300; i--) 
            hit += hits.get(i) == null ? 0 : hits.get(i);
        return hit;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */