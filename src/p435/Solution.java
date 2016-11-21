package p435;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.end - interval2.end;
            }
        });
        
        int count = 1;
        int end = intervals[0].end;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        
        return intervals.length - count;
    }
    
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}