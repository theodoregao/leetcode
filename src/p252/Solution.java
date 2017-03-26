package p252;

import java.util.Arrays;

import data.Interval;

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i - 1].end > intervals[i].start) return false;
        return true;
    }
}