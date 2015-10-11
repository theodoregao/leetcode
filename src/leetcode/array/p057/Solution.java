package leetcode.array.p057;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {
    
    private List<Interval> merge(List<Interval> intervals) {
        
        List<Interval> mergedIntevals = new ArrayList<Interval>();
        
        if (intervals.size() == 0) return mergedIntevals;
        
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval left, Interval right) {
                //return left.start != right.start ? left.start - right.start : left.end - right.end;
                return left.start - right.start;
            }
        });
        
        Interval current = intervals.get(0);
        
        for (Interval interval: intervals) {
            if (current.end >= interval.start) current = new Interval(current.start, Math.max(current.end, interval.end));
            else {
                mergedIntevals.add(current);
                current = interval;
            }
        }
        
        mergedIntevals.add(current);
        
        return mergedIntevals;
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }
}