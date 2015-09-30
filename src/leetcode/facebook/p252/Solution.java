package leetcode.facebook.p252;

import java.util.Arrays;
import java.util.Comparator;

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
    public boolean canAttendMeetings(Interval[] intervals) {
        int size = intervals.length;
        if (size <= 1) return true;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval left, Interval right) {
                return left.start - right.start;
            }
        };
        
        Arrays.sort(intervals, comparator);
        
        for (int i = 1; i < size; i++) if (intervals[i - 1].end > intervals[i].start) return false;
        
        return true;
    }
}