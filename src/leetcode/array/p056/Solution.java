package leetcode.array.p056;

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
    public List<Interval> merge(List<Interval> intervals) {
        
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
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(1, 3));
        
        for (Interval interval: new Solution().merge(intervals)) {
            System.out.println(interval.start + ", " + interval.end);
        }
    }
}