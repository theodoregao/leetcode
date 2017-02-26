package p056;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Interval> merge(List<Interval> list) {
        int n = list.size();
        if (n == 0) return list;
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) intervals[i] = list.get(i);
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval left, Interval right) {
                return left.start - right.start;
            }
        });
        List<Interval> rst = new ArrayList<>();
        boolean[] removed = new boolean[n];
        for (int i = 0; i < intervals.length; i++) {
            if (removed[i]) continue;
            Interval one = intervals[i];
            removed[i] = true;
            for (int j = i + 1; j < intervals.length; j++) {
                if (removed[j]) continue;
                Interval other = intervals[j];
                if (intersect(one, other)) {
                    removed[j] = true;
                    one = merge(one, other);
                }
            }
            rst.add(one);
        }
        
        return rst;
    }
    
    private boolean intersect(Interval one, Interval other) {
        return !(one.end < other.start || one.start > other.end); 
    }
    
    private Interval merge(Interval one, Interval other) {
        return new Interval(Math.min(one.start, other.start), Math.max(one.end, other.end));
    }
}